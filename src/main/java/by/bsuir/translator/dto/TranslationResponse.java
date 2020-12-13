package by.bsuir.translator.dto;

import by.bsuir.translator.model.Word;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TranslationResponse {
    private String translatedText;
    private List<Word> wordsDB;
    private List<Word> wordsCloud;
}
