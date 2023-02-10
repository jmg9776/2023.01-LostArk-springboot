package com.example.lostark.api.pub;

import com.example.lostark.service.aggregator.lostArk.UpdateFixedData;
import com.example.lostark.service.aggregator.lostArk.expedition.UpdateExpedition;
import com.example.lostark.service.persist.view.ChaosDungeonCalculateService;
import com.example.lostark.service.persist.view.GuardianRaidCalculateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("/public-api/v1")
public class PublicTestApi {

    private final UpdateExpedition expeditionUpdate;

    private final UpdateFixedData updateFixedData;

    private final ChaosDungeonCalculateService chaosDungeonCalculateService;

    private final GuardianRaidCalculateService guardianRaidCalculateService;

    @GetMapping("/test2")
    public Object test2() {
        updateFixedData.updateAll();
        expeditionUpdate.update(2L);
        return guardianRaidCalculateService.getData(1600L);
    }
}
