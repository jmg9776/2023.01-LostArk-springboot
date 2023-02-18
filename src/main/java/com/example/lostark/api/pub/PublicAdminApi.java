package com.example.lostark.api.pub;

import ch.qos.logback.classic.Logger;
import com.example.lostark.service.aggregator.lostArk.UpdateFixedData;
import com.example.lostark.service.aggregator.lostArk.expedition.UpdateExpedition;
import com.example.lostark.service.persist.view.ChaosDungeonCalculateService;
import com.example.lostark.service.persist.view.GuardianRaidCalculateService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("/public-api/v1")
public class PublicAdminApi {

    private final UpdateExpedition expeditionUpdate;

    private final UpdateFixedData updateFixedData;

    private final ChaosDungeonCalculateService chaosDungeonCalculateService;

    private final GuardianRaidCalculateService guardianRaidCalculateService;

    @GetMapping("/updateTest")
    public void updateTest() {
        updateFixedData.updateAll();
        expeditionUpdate.update(1L);
    }

    @Async
    @Scheduled(fixedRate = 3600000)
    public void update() {
        updateFixedData.updateAll();
    }

    @GetMapping("/guardianRaidCalTest")
    public Object guardianRaidCalTest() {
        return guardianRaidCalculateService.getData(1600L);
    }

    @GetMapping("/chaosDungeonCalTest")
    public Object chaosDungeonCalTest() {
        return chaosDungeonCalculateService.getData(1600L);
    }
}
