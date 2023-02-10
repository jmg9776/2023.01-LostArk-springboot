package com.example.lostark.repository;

import com.example.lostark.model.entity.ChaosDungeon;

public interface ChaosDungeonRepository extends BaseRepository<ChaosDungeon, Long> {
    ChaosDungeon findTopByLevelLessThanEqualOrderByLevelDesc(Integer level);
}
