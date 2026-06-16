package com.studentmark.service;

import com.studentmark.entity.Student;
import com.studentmark.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setRollNo(updatedStudent.getRollNo());
            student.setName(updatedStudent.getName());
            student.setClassName(updatedStudent.getClassName());
            student.setSection(updatedStudent.getSection());

            return studentRepository.save(student);
        }

        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}