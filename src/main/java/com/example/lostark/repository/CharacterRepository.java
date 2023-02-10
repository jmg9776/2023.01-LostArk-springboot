package com.example.lostark.repository;

import com.example.lostark.model.entity.CharacterInfo;

import java.util.Optional;

public interface CharacterRepository extends BaseRepository<CharacterInfo, Long>{
    Optional<CharacterInfo> findCharacterInfoByCharacterName(String characterName);
}
