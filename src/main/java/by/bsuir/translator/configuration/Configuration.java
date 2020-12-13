package by.bsuir.translator.configuration;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    Translate translate(){
        return TranslateOptions.newBuilder().setTargetLanguage("ru").build().getService();
    }
}
