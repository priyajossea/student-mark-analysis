package com.studentmark.controller;

import com.studentmark.dto.ResultResponse;
import com.studentmark.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/{studentId}")
    public ResultResponse getResult(
            @PathVariable Long studentId) {

        return resultService.calculateResult(studentId);
    }
}