package by.bsuir.translator.model;

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
    private List<TranslatedWord> wordsDB;
    private List<TranslatedWord> wordsCloud;
    private String translatedText;
}
