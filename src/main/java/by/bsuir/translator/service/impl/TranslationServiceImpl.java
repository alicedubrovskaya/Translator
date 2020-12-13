package by.bsuir.translator.service.impl;

import by.bsuir.translator.dto.TranslationResponse;
import by.bsuir.translator.model.TranslatedWord;
import by.bsuir.translator.model.TranslationType;
import by.bsuir.translator.model.Word;
import by.bsuir.translator.repository.WordRepository;
import by.bsuir.translator.service.TextService;
import by.bsuir.translator.service.TranslationService;
import by.bsuir.translator.service.WordService;
import com.google.cloud.translate.Translate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {
    private final Translate translate;
    private final TextService textService;
    private final WordService wordService;
    private final WordRepository wordRepository;

    @Override
    public TranslationResponse translate(String text) {
        List<String[]> sentences = textService.splitBySentencesAndWords(text);

        List<List<TranslatedWord>> translatedSentences = sentences.stream().map(sentence ->
                Arrays.stream(sentence).map(word -> {
                    Optional<Word> englishWord = wordRepository.findByEnglishWord(word);
                    if (englishWord.isPresent()) {
                        return TranslatedWord.builder()
                                .word(englishWord.get().getRussianWord())
                                .englishWord(word)
                                .translationType(TranslationType.DATABASE)
                                .build();
                    } else {
                        try {
//                            Translation translation = translate.translate(word);
//                            return TranslatedWord.builder()
//                                    .word(translation.getTranslatedText())
//                                    .englishWord(word)
//                                    .translationType(TranslationType.CLOUD)
//                                    .build();
                        } catch (Exception ex) {
                            ex.getCause();
                        }
                        return null;
                    }
                }).collect(Collectors.toList())).collect(Collectors.toList());

        List<TranslatedWord> sortedWords = wordService.getSortedWords(translatedSentences);
        List<TranslatedWord> translatedByDataBase = sortedWords.stream()
                .filter(word -> word.getTranslationType().equals(TranslationType.DATABASE))
                .collect(Collectors.toList());

        List<TranslatedWord> translatedByCloud = sortedWords.stream()
                .filter(word -> word.getTranslationType().equals(TranslationType.GOOGLE))
                .collect(Collectors.toList());

        return TranslationResponse.builder()
                .translatedText(textService.toText(translatedSentences))
                .wordsDB(translatedByDataBase)
                .wordsCloud(translatedByCloud)
                .build();
    }
}
