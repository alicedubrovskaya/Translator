package by.bsuir.translator.service;

import by.bsuir.translator.dto.TranslationResult;

public interface TranslationService {
    TranslationResult translate(String text);

}
