package com.example.lostark.service.front;

import com.example.lostark.model.entity.Expedition;
import com.example.lostark.model.entity.Member;
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
    private final RestResultBuilder<Class> resultBuilder = new RestResultBuilder<>(Expedition.class,"member");

    public RestResult getExpedition(long uid) {
        List<Expedition> expeditionList = expeditionService.findAllByUid(uid);
        return new RestResult(resultBuilder.listResultBuilder(Collections.singletonList(expeditionList)));
    }
}
