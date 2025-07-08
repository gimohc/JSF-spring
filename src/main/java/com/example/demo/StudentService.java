package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }
    public void save(String name, double balance) {
        studentRepository.save(new Student(name, balance));
    }
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }
    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
