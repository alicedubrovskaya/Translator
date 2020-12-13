package by.bsuir.translator.service.impl;

import by.bsuir.translator.model.Word;
import by.bsuir.translator.repository.WordRepository;
import by.bsuir.translator.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @SneakyThrows
    @Override
    public void uploadWords(MultipartFile file) {
        String content = new String(file.getBytes());
        String[] words = content.split("\r\n");
        for (String word : words) {
            String[] split = word.split(" ");
            String english = split[0];
            String russian = split[1];
            if (!wordRepository.findByEnglishWord(english).isPresent()) {
                Word wordTranslation = Word.builder()
                        .englishWord(english)
                        .russianWord(russian)
                        .build();
                wordRepository.save(wordTranslation);
            }
        }
    }
}
