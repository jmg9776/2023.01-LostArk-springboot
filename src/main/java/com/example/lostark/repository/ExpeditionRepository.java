package com.example.lostark.repository;

import com.example.lostark.model.entity.Expedition;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ExpeditionRepository extends BaseRepository<Expedition, Long> {
    @Query("select t from Expedition t join fetch t.characterInfo join fetch t.member")
    ArrayList<Expedition> findAllByMember_Uid(Long uid);
}