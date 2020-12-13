package by.bsuir.translator.service;

import by.bsuir.translator.model.TranslatedWord;

import java.util.List;

public interface TextService {
    String[] splitBySentences(String text);

    String clean(String text);

    List<String[]> splitBySentencesAndWords(String text);

    String toText(List<List<TranslatedWord>> text);

}
