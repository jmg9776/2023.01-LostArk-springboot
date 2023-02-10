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
public class AuctionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long startPrice;
    private Long buyPrice;
    private Long bidPrice;
    private Long bidCount;
    private Long bidStartPrice;

    public AuctionInfo() {
    }
}
