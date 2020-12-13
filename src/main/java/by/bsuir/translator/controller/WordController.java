package by.bsuir.translator.controller;

import by.bsuir.translator.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
@RequestMapping("/translation")
public class WordController {
    private final WordService wordService;

    @PostMapping("/upload")
    public void upload(@RequestParam(name = "file") MultipartFile file) {
        wordService.uploadWords(file);
    }
}
