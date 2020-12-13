package by.bsuir.translator.dto;

import by.bsuir.translator.model.TranslatedWord;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TranslationResult {
    private String translatedText;
    private List<TranslatedWord> wordsDB;
    private List<TranslatedWord> wordsCloud;
}
