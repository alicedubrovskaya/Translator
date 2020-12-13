package by.bsuir.translator.service.impl;

import by.bsuir.translator.model.TranslatedWord;
import by.bsuir.translator.service.TextService;
import by.bsuir.translator.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TextServiceImpl implements TextService {
    private final WordService wordService;

    @Override
    public String[] splitBySentences(String text) {
        return text.split("[.!?]\\s");
    }

    public String[] splitByWords(String text) {
        String cleanedText = clean(text);
        return cleanedText.split(" ");
    }

    @Override
    public String clean(String text) {
        return text
                .replaceAll("[–,.;:!?]", "")
                .replaceAll("\r\n", " ")
                .replaceAll("\n", "")
                .replaceAll("\t", " ")
                .replaceAll("  ( )*", " ").toLowerCase();
    }

    @Override
    public List<String[]> splitBySentencesAndWords(String text) {
        String[] sentences = splitBySentences(text);
        return Arrays.stream(sentences).map(sentence -> splitByWords(clean(sentence))).
                collect(Collectors.toList());
    }

    @Override
    public String toText(List<List<TranslatedWord>> text) {
        for (List<TranslatedWord> sentence: text){
            String firstWord = wordService.toUpperCaseFirstSymbol(sentence.get(0).getWord());
            sentence.get(0).setWord(firstWord);
        }
        return text.stream().map(sentence -> {
            return sentence.stream().map(TranslatedWord::getWord).
                    collect(Collectors.joining(" "));
        }).collect(Collectors.joining(". "));
    }
}
