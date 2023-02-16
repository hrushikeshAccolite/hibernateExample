package com.student.management.services;

import com.student.management.models.School;
import com.student.management.models.Subject;
import com.student.management.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServices {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> findAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject findSubjectById(Integer id){
        return subjectRepository.findById(id).get();
    }

    public void saveSubject(Subject s) {
        subjectRepository.save(s);
    }
}
