package by.bsuir.translator.service;

import java.util.List;

public interface TextService {
    String[] splitBySentences(String text);

    String clean(String text);

    List<String[]> splitBySentencesAndWords(String text);

}
