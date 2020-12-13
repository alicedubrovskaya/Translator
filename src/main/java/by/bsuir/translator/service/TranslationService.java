package by.bsuir.translator.service;

import by.bsuir.translator.dto.TranslationResponse;

public interface TranslationService {
    TranslationResponse translate(String text);

}
