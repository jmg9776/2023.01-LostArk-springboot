package com.example.lostark.schedule;

import com.example.lostark.service.aggregator.lostArk.UpdateFixedData;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class UpdateSchedule {

    private final UpdateFixedData updateFixedData;

    @Async
    @Scheduled(fixedDelay = 0,fixedRate = 3600000)
    public void update() {
        updateFixedData.updateAll();
    }
}
