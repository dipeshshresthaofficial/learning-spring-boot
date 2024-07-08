package com.dipeshcodes.QuizAppMonolythic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "question_title")
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String category;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    @Column(name = "right_answer")
    private String rightAnswer;
}
