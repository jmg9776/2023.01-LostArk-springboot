package com.example.lostark.model.entity.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Data
public class GuardianRaidCalculate {
    @Id
    private Long level;

    private Double destruction;

    private Double guardian;

    private Double stone;

    private Double total;

    protected GuardianRaidCalculate() {
    }
}
