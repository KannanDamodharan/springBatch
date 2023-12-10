package com.varks.batch.config;

import com.varks.batch.student.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        //business logic goes here
        student.setId(null);
        return student;
    }
}
