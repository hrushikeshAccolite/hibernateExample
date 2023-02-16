package com.student.management.services;

import com.student.management.models.School;
import com.student.management.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServices {

    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> findAllSchool(){
        return schoolRepository.findAll();
    }

    public School findSchoolById(Integer id){
        return schoolRepository.findById(id).get();
    }

    public void saveSchool(School s) {
        schoolRepository.save(s);
    }
}
