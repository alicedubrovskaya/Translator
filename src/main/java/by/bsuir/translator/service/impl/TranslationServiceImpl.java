package by.bsuir.translator.service.impl;

import by.bsuir.translator.dto.TranslationResponse;
import by.bsuir.translator.service.TextService;
import by.bsuir.translator.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {
    private final TextService textService;

    @Override
    public TranslationResponse translate(String text) {
        List<String[]> sentences = textService.splitBySentencesAndWords(text);
        return null;
    }
}
