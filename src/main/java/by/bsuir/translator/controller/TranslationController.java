package by.bsuir.translator.controller;

import by.bsuir.translator.model.TranslationResult;
import by.bsuir.translator.service.TranslationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/translator")
@RequiredArgsConstructor
public class TranslationController {
    private final TranslationService translationService;

    @GetMapping("/translate")
    @SneakyThrows
    public TranslationResult translate(@RequestParam("file") MultipartFile file) {
        String text = new String(file.getBytes());
        return translationService.translate(text);
    }
}
