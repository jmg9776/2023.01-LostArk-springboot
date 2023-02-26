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

    @Lob
    @Column(name = "apiKey", length = 512)
    String apiKey;
    @ManyToOne
    Member member;

    public ApiKeys() {

    }
}
