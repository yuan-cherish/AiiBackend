package com.example.interviewbackend.controller.dto;

import lombok.Data;

@Data
public class ScoreDTO {
    private String userPhone;
    private Integer score;
    private String nature;
    private String answerTime;
}
