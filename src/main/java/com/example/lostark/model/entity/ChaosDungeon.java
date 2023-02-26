package com.example.lostark.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
public class ChaosDungeon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private Long level;
    private Long grade;
    private double destruction;
    private double guardian;
    private double gem;
    private double bonus;
    public ChaosDungeon() {

    }
}
