package com.example.demo;

import jakarta.inject.Named;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.faces.view.ViewScoped; // Make sure this is jakarta.faces.view.ViewScoped

@Component // Marks it as a Spring component
@ViewScoped // Makes it a JSF ViewScoped bean (recognized by JoinFaces)
@NoArgsConstructor(force = true) // For Lombok to generate default constructor
@Named("dataView") // Gives it the JSF EL name "dataView"
public class DataView {

    @Getter @Setter
    private Iterable<Student> students; // Ensure Student class exists and is a POJO

    @Getter @Setter
    private String newStudentName;

    @Getter @Setter
    private double newStudentBalance;

    private final StudentService studentService;

    @Autowired
    public DataView(StudentService studentService) {
        this.studentService = studentService;
        this.students = studentService.findAll();
    }
    public void save() {
        studentService.save(newStudentName, newStudentBalance);
        newStudentName = "";
        newStudentBalance = 0;
        students = studentService.findAll();
    }
    public void delete(long id) {
        studentService.delete(id);
        students = studentService.findAll();
    }
}