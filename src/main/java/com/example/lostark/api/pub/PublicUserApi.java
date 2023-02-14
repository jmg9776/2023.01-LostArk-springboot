package com.example.lostark.api.pub;

import com.example.lostark.model.param.MemberParam;
import com.example.lostark.model.param.RefreshExpeditionParam;
import com.example.lostark.model.result.RestResult;
import com.example.lostark.service.front.ExpeditionFrontService;
import com.example.lostark.service.front.MemberFrontService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/public-api/v1")
public class PublicUserApi {
    private final MemberFrontService memberFrontService;
    private final ExpeditionFrontService expeditionFrontService;

    @PostMapping("/sign")
    public RestResult sign(@RequestBody MemberParam memberParam) {
        return memberFrontService.sign(memberParam);
    }

    @PostMapping("/getExpedition")
    public RestResult getExpedition(@RequestBody MemberParam memberParam) {
        return expeditionFrontService.getExpedition(memberParam.getUid());
    }
}
