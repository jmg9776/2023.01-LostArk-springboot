package com.example.lostark.service.persist.view;

import com.example.lostark.model.entity.view.ChaosDungeonCalculate;
import com.example.lostark.repository.view.ChaosDungeonCalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChaosDungeonCalculateService {

    private final ChaosDungeonCalculateRepository chaosDungeonCalculateRepository;

    public ChaosDungeonCalculate getData(Long target) {
        return chaosDungeonCalculateRepository.findTopByLevelLessThanEqualOrderByLevelDesc(target);
    }

    public List<ChaosDungeonCalculate> findAll() {
        return chaosDungeonCalculateRepository.findAll();
    }
}
