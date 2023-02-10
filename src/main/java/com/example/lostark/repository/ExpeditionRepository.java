package com.example.lostark.repository;

import com.example.lostark.model.entity.Expedition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ExpeditionRepository extends BaseRepository<Expedition, Long> {
    ArrayList<Expedition> findAllByMember_Uid(Long uid);
}
