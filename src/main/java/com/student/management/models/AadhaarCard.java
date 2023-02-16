package com.student.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
public class AadhaarCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String aadhaarNumber;
}
