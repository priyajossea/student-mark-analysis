package com.studentmark.service;

import com.studentmark.entity.Marks;
import com.studentmark.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    public Marks getMarksById(Long id) {
        return marksRepository.findById(id).orElse(null);
    }

    public Marks updateMarks(Long id, Marks updatedMarks) {

        Marks marks = marksRepository.findById(id).orElse(null);

        if (marks != null) {
            marks.setStudent(updatedMarks.getStudent());
            marks.setSubject(updatedMarks.getSubject());
            marks.setMark(updatedMarks.getMark());

            return marksRepository.save(marks);
        }

        return null;
    }

    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
}