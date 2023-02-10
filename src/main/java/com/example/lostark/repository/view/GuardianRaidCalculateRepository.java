package com.example.lostark.repository.view;

import com.example.lostark.model.entity.view.GuardianRaidCalculate;
import com.example.lostark.repository.BaseRepository;
import org.springframework.cache.annotation.Cacheable;


public interface GuardianRaidCalculateRepository extends BaseRepository<GuardianRaidCalculate, Long> {
    @Cacheable(value = "GuardianRaidCalculate", key="#level")
    GuardianRaidCalculate findTopByLevelLessThanEqualOrderByLevelDesc(Long level);
}