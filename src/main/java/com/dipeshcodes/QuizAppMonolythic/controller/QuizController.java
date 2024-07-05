package com.dipeshcodes.QuizAppMonolythic.controller;

import com.dipeshcodes.QuizAppMonolythic.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // For admin, who wants to create a new Quiz
    @PostMapping("/create")
    private String createQuiz(@RequestParam String category, @RequestParam String quizTitle, @RequestParam Integer noOfQue){
        return quizService.createQuiz(category,quizTitle,noOfQue);
    }
}
