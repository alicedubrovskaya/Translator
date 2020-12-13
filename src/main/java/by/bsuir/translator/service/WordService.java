package by.bsuir.translator.service;

import by.bsuir.translator.model.TranslatedWord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WordService {
    void uploadWords(MultipartFile file);

    List<TranslatedWord> getSortedWords(List<List<TranslatedWord>> sentences);

    String toUpperCaseFirstSymbol(String word);
}
