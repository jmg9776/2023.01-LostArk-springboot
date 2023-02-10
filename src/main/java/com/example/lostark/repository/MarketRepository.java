package com.example.lostark.repository;

import com.example.lostark.model.entity.Market;

import java.util.List;

public interface MarketRepository extends BaseRepository<Market,Long> {
    List<Market> findAllByGrade(Long grade);
}
