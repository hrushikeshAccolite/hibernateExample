package com.student.management;

import com.student.management.models.School;
import com.student.management.models.Student;
import com.student.management.services.SchoolServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OneToManyTest {

    @Autowired
    private SchoolServices schoolServices;

    @Test
    void saveStudents(){
        School school = new School();
        school.setSchoolName("Accolite");
        school.setSchoolAddress("Bangalore");

        Student s1 = new Student();
        s1.setName("abc");
        s1.setGrade(4);
        s1.setContactNumber(9987344981L);

        Student s2 = new Student();
        s2.setName("def");
        s2.setGrade(3);
        s2.setContactNumber(9987344982L);

        Student s3 = new Student();
        s3.setName("ghi");
        s3.setGrade(2);
        s3.setContactNumber(9987344983L);

        school.getStudents().add(s1);
        school.getStudents().add(s2);
        school.getStudents().add(s3);

        schoolServices.saveSchool(school);
    }

    @Test
    public void findAll(){
        List<School> schoolList = schoolServices.findAllSchool();
        System.out.println(schoolList);

    }

}
