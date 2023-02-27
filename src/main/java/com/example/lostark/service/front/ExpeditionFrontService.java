package com.example.lostark.service.front;

import com.example.lostark.model.entity.Expedition;
import com.example.lostark.model.param.MemberParam;
import com.example.lostark.model.result.RestResult;
import com.example.lostark.service.aggregator.lostArk.expedition.UpdateExpedition;
import com.example.lostark.service.persist.ExpeditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpeditionFrontService extends FrontService{
    private final ExpeditionService expeditionService;
    private final UpdateExpedition updateExpedition;

    public RestResult getExpedition(MemberParam memberParam) {
        long uid=0l;
        if (memberParam.getUid() != null) uid = memberParam.getUid();
        else return null;
        updateExpedition.update(uid);
        List<Expedition> expeditionList = expeditionService.findAllByUid(uid);
        return resultBuilder.resultBuilder("expeditionList",expeditionList);
    }
}
