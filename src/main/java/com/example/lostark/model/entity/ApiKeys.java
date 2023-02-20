package com.example.lostark.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class ApiKeys {
    @Id
    String apiKey;

    public ApiKeys() {

    }
}
