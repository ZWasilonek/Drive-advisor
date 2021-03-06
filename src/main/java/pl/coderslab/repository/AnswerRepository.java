package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Answer;

import java.util.Set;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT a.id, a.description, a.is_correct, a.file_id FROM question_answers JOIN answers a on question_answers.answer_id = a.id WHERE question_id=:questionId AND a.is_correct='1'", nativeQuery = true)
    Set<Answer> findCorrectAnswersByQuestionId(@Param("questionId") Long questionId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM question_answers WHERE answer_id=:answerId", nativeQuery = true)
    void removeAnswerFromQuestion(@Param("answerId") Long answerId);

}