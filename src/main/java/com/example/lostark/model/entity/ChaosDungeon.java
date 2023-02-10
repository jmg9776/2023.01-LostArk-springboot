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
    private Long destruction;
    private Long guardian;
    private Long gem;

    public ChaosDungeon() {

    }
}
