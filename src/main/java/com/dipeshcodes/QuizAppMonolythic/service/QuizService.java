package com.dipeshcodes.QuizAppMonolythic.service;

import com.dipeshcodes.QuizAppMonolythic.dao.QuestionDao;
import com.dipeshcodes.QuizAppMonolythic.dao.QuizDao;
import com.dipeshcodes.QuizAppMonolythic.model.Question;
import com.dipeshcodes.QuizAppMonolythic.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;
    public String createQuiz(String category, String quizTitle, Integer noOfQue) {
        List<Question> ques = questionDao.getNoOfRandomQuestionsByCategory(noOfQue, category);
        System.out.println(ques);
        Quiz quiz = new Quiz(quizTitle, ques);
        quizDao.save(quiz);
        return "Success";
    }
}
