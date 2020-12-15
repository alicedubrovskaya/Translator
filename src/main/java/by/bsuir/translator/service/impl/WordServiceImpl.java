package by.bsuir.translator.service.impl;

import by.bsuir.translator.model.TranslatedWord;
import by.bsuir.translator.model.Word;
import by.bsuir.translator.repository.WordRepository;
import by.bsuir.translator.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @SneakyThrows
    @Override
    public void uploadWords(MultipartFile file) {
        String content = new String(file.getBytes());
        String[] words = content.split("\r\n\r\n");
        for (String word : words) {
            String[] split = word.split("\r\n");
            String english = split[0];
            String russian = split[1];
            if (!wordRepository.findByEnglishWord(english).isPresent()) {
                Word wordTranslation = Word.builder()
                        .englishWord(english)
                        .russianWord(russian)
                        .build();
                wordRepository.save(wordTranslation);
            }
        }
    }

    @Override
    public List<TranslatedWord> getSortedWords(List<List<TranslatedWord>> sentences) {
        List<TranslatedWord> words = new ArrayList<>();
        sentences.forEach(words::addAll);

        Map<TranslatedWord, Integer> wordsFrequency = new HashMap<>();

        words.forEach(word -> {
            if(wordsFrequency.containsKey(word)){
                Integer occurrence = wordsFrequency.get(word);
                wordsFrequency.put(word, occurrence+1);
            }else {
                wordsFrequency.put(word, 1);
            }
        });
        return wordsFrequency.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public String toUpperCaseFirstSymbol(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
