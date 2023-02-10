package com.example.lostark.model.entity.auction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class AuctionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String grade;
    private Long tier;
    private Long level;
    private String icon;
    private Long gradeQuality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_info_id")
    private AuctionInfo auctionInfo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="auction_option_id")
    private List<AuctionOptions> options;

    public AuctionProduct() {

    }
}
