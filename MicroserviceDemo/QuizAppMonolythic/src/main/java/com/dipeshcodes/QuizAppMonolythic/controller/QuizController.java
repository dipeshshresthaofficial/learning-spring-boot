package com.dipeshcodes.QuizAppMonolythic.controller;

import com.dipeshcodes.QuizAppMonolythic.model.Question;
import com.dipeshcodes.QuizAppMonolythic.model.QuestionWrapper;
import com.dipeshcodes.QuizAppMonolythic.model.Quiz;
import com.dipeshcodes.QuizAppMonolythic.model.Response;
import com.dipeshcodes.QuizAppMonolythic.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // For admin, who wants to create a new Quiz
    @PostMapping("/create")
    private ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam String quizTitle, @RequestParam Integer noOfQue){
        return quizService.createQuiz(category,quizTitle,noOfQue);
    }

    // When user wants to attempt a quiz
    @GetMapping("{id}")
    private ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("{id}/score")
    private ResponseEntity<Integer> calculateScore(@PathVariable Integer id, @RequestBody ArrayList<Response> response){
        return quizService.calculateScore(id, response);
    }
}
