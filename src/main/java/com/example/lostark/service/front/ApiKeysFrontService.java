package com.example.lostark.service.front;

import com.example.lostark.model.result.RestResult;
import com.example.lostark.service.persist.ApiKeysService;
import com.example.lostark.service.persist.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeysFrontService extends FrontService{
    private final ApiKeysService apiKeysService;

    public RestResult findApiKeyByUid(Long uid) {
        return resultBuilder.resultBuilder("ApiKeys", apiKeysService.findApiKeyByUid(uid));
    }
}
