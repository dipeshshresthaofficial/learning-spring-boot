package com.dipeshcodes.QuizAppMonolythic.service;

import com.dipeshcodes.QuizAppMonolythic.dao.QuestionDao;
import com.dipeshcodes.QuizAppMonolythic.dao.QuizDao;
import com.dipeshcodes.QuizAppMonolythic.model.Question;
import com.dipeshcodes.QuizAppMonolythic.model.QuestionWrapper;
import com.dipeshcodes.QuizAppMonolythic.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;
    public ResponseEntity<Quiz> createQuiz(String category, String quizTitle, Integer noOfQue) {
        List<Question> ques = questionDao.getNoOfRandomQuestionsByCategory(noOfQue, category);
        System.out.println(ques);
        Quiz quiz = new Quiz(quizTitle, ques);
        quizDao.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Optional<Quiz> quiz = quizDao.findById(quizId);
        if(quiz != null){
            List<Question> questionsFromDB = quiz.get().getQuestions();
            List<QuestionWrapper> questionsAfterWrapped = new ArrayList<>();
            for(Question que: questionsFromDB){
                QuestionWrapper qWrapper = new QuestionWrapper(
                        que.getId(),
                        que.getQuestionTitle(),
                        que.getOption1(),
                        que.getOption2(),
                        que.getOption3(),
                        que.getOption4());
                questionsAfterWrapped.add(qWrapper);
            }
            try{
                return new ResponseEntity<>(questionsAfterWrapped, HttpStatus.OK);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
