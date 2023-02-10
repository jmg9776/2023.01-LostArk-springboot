package com.example.lostark.model.entity.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Immutable
@Data
public class ChaosDungeonCalculate {
    @Id
    @Column(name = "level")
    private Long level;

    private BigDecimal gem;

    private Double destruction;

    private Double guardian;

    private Integer bonus;

    private Double total;

    protected ChaosDungeonCalculate() {
    }
}