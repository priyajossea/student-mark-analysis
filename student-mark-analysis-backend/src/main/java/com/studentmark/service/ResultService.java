package com.studentmark.service;

import com.studentmark.dto.ResultResponse;
import com.studentmark.entity.Marks;
import com.studentmark.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private MarksRepository marksRepository;

    public ResultResponse calculateResult(Long studentId) {

        List<Marks> marksList =
                marksRepository.findByStudentId(studentId);

        if (marksList.isEmpty()) {
            throw new RuntimeException("No marks found for student id: " + studentId);
        }

        ResultResponse response = new ResultResponse();

        int totalMarks = 0;

        for (Marks marks : marksList) {
            totalMarks += marks.getMark();
        }

        response.setTotalMarks(totalMarks);

        response.setStudentName(
                marksList.get(0).getStudent().getName()
        );

        double average =
                (double) totalMarks / marksList.size();

        response.setAverage(average);

        double percentage = average;

        response.setPercentage(percentage);

        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        response.setGrade(grade);

        String result;

        if (percentage >= 50) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        response.setResult(result);

        return response;
    }
}