package com.example.lostark.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class ApiKeys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "apiKey")
    String apiKey;
    @ManyToOne
    Member member;

    public ApiKeys() {

    }
}
