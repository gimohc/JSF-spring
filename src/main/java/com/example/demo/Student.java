package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Student implements java.io.Serializable{

    public Student(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(generator = "student_sequence")
    @Getter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private double balance;
}
