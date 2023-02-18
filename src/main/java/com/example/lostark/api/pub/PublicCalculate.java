package com.example.lostark.api.pub;

import com.example.lostark.model.result.RestResult;
import com.example.lostark.service.front.CalculateFrontService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/public-api/v1/cal")
public class PublicCalculate {
    private final CalculateFrontService calculateFrontService;

    @GetMapping("/getAllChaosDungeon")
    public RestResult getAllChaosDungeon() {
        return calculateFrontService.getAllCalChaosDungeon();
    }

    @GetMapping("/getAllGuardianRaid")
    public RestResult getAllGuardianRaid() {
        return calculateFrontService.getAllCalGuardianRaid();
    }
}
