package com.dipeshcodes.QuizAppMonolythic.service;

import com.dipeshcodes.QuizAppMonolythic.dao.QuestionDao;
import com.dipeshcodes.QuizAppMonolythic.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestion() {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
    }
}
