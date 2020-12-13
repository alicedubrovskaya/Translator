package by.bsuir.translator.controller;

import by.bsuir.translator.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/translator")
public class FileController {
    private final WordService wordService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/upload")
    public void upload(@RequestParam(name = "file") MultipartFile file) {
        wordService.uploadWords(file);
    }
}
