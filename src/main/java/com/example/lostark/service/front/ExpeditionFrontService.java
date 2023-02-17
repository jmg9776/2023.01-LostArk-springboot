package com.example.lostark.service.front;

import com.example.lostark.model.entity.Expedition;
import com.example.lostark.model.entity.Member;
import com.example.lostark.model.param.MemberParam;
import com.example.lostark.model.result.RestResult;
import com.example.lostark.model.result.RestResultBuilder;
import com.example.lostark.service.persist.ExpeditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExpeditionFrontService {
    private final ExpeditionService expeditionService;
    private final RestResultBuilder resultBuilder;

    public RestResult getExpedition(MemberParam memberParam) {
        long uid=0l;
        if (memberParam.getUid() != null) uid = memberParam.getUid();
        else return null;
        List<Expedition> expeditionList = expeditionService.findAllByUid(uid);
        return resultBuilder.resultBuilder("expeditionList",expeditionList);
    }
}
