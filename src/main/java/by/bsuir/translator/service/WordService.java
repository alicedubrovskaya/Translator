package by.bsuir.translator.service;

import org.springframework.web.multipart.MultipartFile;

public interface WordService {
    void uploadWords(MultipartFile file);
}
