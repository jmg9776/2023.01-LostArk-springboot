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
public class Expedition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    @ManyToOne
    @JoinColumn(name = "member_uid")
    Member member;

    @ManyToOne
    @JoinColumn(name = "character_info_pid")
    CharacterInfo characterInfo;

    public Expedition() {
    }
}
