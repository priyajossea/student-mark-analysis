package com.studentmark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse {

    private String studentName;

    private Integer totalMarks;

    private Double average;

    private Double percentage;

    private String grade;

    private String result;
}