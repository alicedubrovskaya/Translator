package by.bsuir.translator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslatedWord {
    private String englishWord;
    private String word;
    private TranslationType translationType;
}
