package com.example.lostark.model.entity.auction;

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
public class AuctionOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String optionName;
    private String optionNameTripod;
    private Long value;
    private String className;

    public AuctionOptions() {

    }
}
