package com.dipeshcodes.QuizAppMonolythic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quiz_title")
    private String quizTitle;
    @ManyToMany
    private List<Question> questions;

    public Quiz(String quizTitle, List<Question> questions) {
        this.quizTitle = quizTitle;
        this.questions = questions;
    }
}
