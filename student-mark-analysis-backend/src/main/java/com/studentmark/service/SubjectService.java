package com.studentmark.service;

import com.studentmark.entity.Subject;
import com.studentmark.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {

        Subject subject = subjectRepository.findById(id).orElse(null);

        if (subject != null) {
            subject.setSubjectName(updatedSubject.getSubjectName());
            subject.setMaxMark(updatedSubject.getMaxMark());

            return subjectRepository.save(subject);
        }

        return null;
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}