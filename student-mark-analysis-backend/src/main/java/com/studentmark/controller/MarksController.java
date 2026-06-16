package com.studentmark.controller;

import com.studentmark.entity.Marks;
import com.studentmark.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping
    public List<Marks> getAllMarks() {
        return marksService.getAllMarks();
    }

    @PostMapping
    public Marks addMarks(@RequestBody Marks marks) {
        return marksService.saveMarks(marks);
    }

    @GetMapping("/{id}")
    public Marks getMarksById(@PathVariable Long id) {
        return marksService.getMarksById(id);
    }

    @PutMapping("/{id}")
    public Marks updateMarks(
            @PathVariable Long id,
            @RequestBody Marks marks) {

        return marksService.updateMarks(id, marks);
    }

    @DeleteMapping("/{id}")
    public String deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
        return "Marks deleted successfully";
    }
}