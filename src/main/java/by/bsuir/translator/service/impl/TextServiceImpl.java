package by.bsuir.translator.service.impl;

import by.bsuir.translator.service.TextService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TextServiceImpl implements TextService {

    @Override
    public String[] splitBySentences(String text) {
        return text.split("[.!?]");
    }

    public String[] splitByWords(String text) {
        String cleanedText = clean(text);
        return cleanedText.split(" ");
    }

    @Override
    public String clean(String text) {
        return text
                .replaceAll("[–,.;:!?]", "")
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .replaceAll("  ( )*", " ").toLowerCase();
    }

    @Override
    public List<String[]> splitBySentencesAndWords(String text) {
        String[] sentences = splitBySentences(text);
        return Arrays.stream(sentences).map(sentence -> splitByWords(clean(sentence))).
                collect(Collectors.toList());
    }
}
