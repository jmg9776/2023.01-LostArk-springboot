package com.example.lostark.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown =true)
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long bundleCount;
    private Double avgPrice;
    private Long grade;

    public Market() {
    }
}
