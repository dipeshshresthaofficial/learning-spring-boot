package com.dipeshcodes.QuizAppMonolythic.controller;

import com.dipeshcodes.QuizAppMonolythic.model.Question;
import com.dipeshcodes.QuizAppMonolythic.service.QuestionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("all")
    private ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @PostMapping("add")
    private ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }


}
