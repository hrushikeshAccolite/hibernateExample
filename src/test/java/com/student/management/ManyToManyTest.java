package com.student.management;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.student.management.models.AadhaarCard;
import com.student.management.services.StudentServices;
import com.student.management.services.SubjectServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.management.models.Student;
import com.student.management.models.Subject;
import com.student.management.repository.SubjectRepository;

@SpringBootTest
public class ManyToManyTest {

    @Autowired
    private StudentServices studentServices;

    @Test
    void saveSubjects(){
        Student student1 = new Student();
        student1.setName("zzz");
        student1.setGrade(5);
        student1.setContactNumber(9987344981L);

        AadhaarCard a1 = new AadhaarCard();
        a1.setAadhaarNumber("1344 5512 6777");
        student1.setAadhaarCard(a1);

        Student student2 = new Student();
        student2.setName("yyy");
        student2.setGrade(10);
        student2.setContactNumber(9981114981L);

        AadhaarCard a2 = new AadhaarCard();
        a2.setAadhaarNumber("4444 5512 6117");
        student1.setAadhaarCard(a2);

        List<Student> stud = new ArrayList<>();
        stud.add(student1);
        stud.add(student2);

        Subject subject = new Subject();
        subject.setSubjectName("Java");

        Subject subject1 = new Subject();
        subject1.setSubjectName("Python");

        Subject subject2 = new Subject();
        subject2.setSubjectName("C++");

        Set<Subject> subjectList = new HashSet<>();
        subjectList.add(subject);
        subjectList.add(subject1);
        subjectList.add(subject2);

        for (Student s :stud){
            s.setSubjects(subjectList);
            for(Subject sb : subjectList){
                    sb.getStudent().add(s);
            }
        }
        for(Student student :stud) {
            studentServices.save(student);
        }
    }
}
