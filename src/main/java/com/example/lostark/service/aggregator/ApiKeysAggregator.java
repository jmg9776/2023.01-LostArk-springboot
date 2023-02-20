package com.example.lostark.service.aggregator;

import com.example.lostark.service.persist.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeysAggregator {
    private final MemberService memberService;

}
