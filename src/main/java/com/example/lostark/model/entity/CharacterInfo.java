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
public class CharacterInfo {
    @Id
    private String characterName;
    private String serverName;
    private String characterClassName;
    private Integer characterLevel;
    private Double itemAvgLevel;
    private Double itemMaxLevel;
    public CharacterInfo() {
    }
}
