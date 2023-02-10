package com.example.lostark.repository;

import com.example.lostark.model.entity.Member;

import java.util.Optional;

public interface MemberRepository extends BaseRepository<Member, Long>{
    Optional<Member> findById(String id);
}
