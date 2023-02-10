package com.example.lostark.service.persist.view;

import com.example.lostark.model.entity.view.GuardianRaidCalculate;
import com.example.lostark.repository.view.GuardianRaidCalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuardianRaidCalculateService {

    private final GuardianRaidCalculateRepository guardianRaidCalculateRepository;
    public GuardianRaidCalculate getData(long target) {
        return guardianRaidCalculateRepository.findTopByLevelLessThanEqualOrderByLevelDesc(target);
    }
}
