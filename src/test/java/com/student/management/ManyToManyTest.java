package com.student.management;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.management.models.Student;
import com.student.management.models.Subject;
import com.student.management.repository.SubjectRepository;

@SpringBootTest
public class ManyToManyTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void saveSubjects(){
        Subject subject = new Subject();
        subject.setSubjectName("Java");

        Subject subject1 = new Subject();
        subject1.setSubjectName("Python");

        Subject subject2 = new Subject();
        subject2.setSubjectName("C++");

        Student student1 = new Student();
        student1.setName("zzz");
        student1.setGrade(5);
        student1.setContactNumber(9987344981L);
        student1.setSubjects(Set.of(subject, subject1, subject2));
        
        subjectRepository.save(subject);
        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
    }

    @Test
    public void findAll(){
        List<Subject> subjectsList = subjectRepository.findAll();
        System.out.println(subjectsList);

    }
}
