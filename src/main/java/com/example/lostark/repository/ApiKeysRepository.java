package com.example.lostark.repository;

import com.example.lostark.model.entity.ApiKeys;
import feign.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApiKeysRepository extends BaseRepository<ApiKeys, Long> {
    @Query("select a.apiKey from ApiKeys as a where a.member.uid=:uid")
    public List<String> findApiKeysByUid(@Param(value = "uid") Long uid);
}
