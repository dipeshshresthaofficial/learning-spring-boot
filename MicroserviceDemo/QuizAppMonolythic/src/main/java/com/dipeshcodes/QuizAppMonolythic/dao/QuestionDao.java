package com.dipeshcodes.QuizAppMonolythic.dao;

import com.dipeshcodes.QuizAppMonolythic.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category =:category Order By Random() Limit :noOfQue", nativeQuery = true)
    List<Question> getNoOfRandomQuestionsByCategory(Integer noOfQue, String category);
}
