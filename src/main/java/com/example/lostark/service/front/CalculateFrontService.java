package com.example.lostark.service.front;

import com.example.lostark.model.entity.Expedition;
import com.example.lostark.model.entity.view.ChaosDungeonCalculate;
import com.example.lostark.model.result.RestResult;
import com.example.lostark.model.result.RestResultBuilder;
import com.example.lostark.service.persist.view.ChaosDungeonCalculateService;
import com.example.lostark.service.persist.view.GuardianRaidCalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CalculateFrontService {
    private final ChaosDungeonCalculateService chaosDungeonCalculateService;
    private final GuardianRaidCalculateService guardianRaidCalculateService;
    private final RestResultBuilder<Class> chaosDungeonResultBuilder = new RestResultBuilder<>(ChaosDungeonCalculate.class,"chaosDungeonCalculate");

    public RestResult getAllCalChaosDungeon() {
        return new RestResult(chaosDungeonResultBuilder.listResultBuilder(Collections.singletonList(chaosDungeonCalculateService.findAll())));
    }
}
