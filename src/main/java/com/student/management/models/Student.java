package com.student.management.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Setter
@Getter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private long contactNumber;

    @Column(name = "grade")
    private int grade;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    AadhaarCard aadhaarCard;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_subject", joinColumns = { @JoinColumn(name = "sub_id") }, inverseJoinColumns = { @JoinColumn(name = "s_id") })
    private Set<Subject> subjects = new HashSet<>();

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber=" + contactNumber +
                ", grade=" + grade +
                '}';
    }
}
