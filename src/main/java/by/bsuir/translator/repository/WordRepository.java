package by.bsuir.translator.repository;

import by.bsuir.translator.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("SELECT word FROM Word word WHERE word.englishWord = ?1")
    Optional<Word> findByEnglishWord(String word);
}