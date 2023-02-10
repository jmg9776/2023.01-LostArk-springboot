package com.example.lostark.repository.view;

import com.example.lostark.model.entity.view.ChaosDungeonCalculate;
import com.example.lostark.repository.BaseRepository;
import org.springframework.cache.annotation.Cacheable;

public interface ChaosDungeonCalculateRepository extends BaseRepository<ChaosDungeonCalculate, Long> {
    @Cacheable(value = "ChaosDungeonCalculate", key="#level")
    ChaosDungeonCalculate findTopByLevelLessThanEqualOrderByLevelDesc(Long level);
}
