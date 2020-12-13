package by.bsuir.translator.controller;

import by.bsuir.translator.dto.TranslationResponse;
import by.bsuir.translator.service.FileService;
import by.bsuir.translator.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translator")
@RequiredArgsConstructor
public class TranslationController {
    private final TranslationService translationService;

    @GetMapping("translate")
    public TranslationResponse translate(@RequestParam(name = "inputText") String text) {
        //TODO
        TranslationResponse translate = translationService.translate(text);
        return translate;
    }

}
