package com.example.lostark.service.persist;

import com.example.lostark.model.entity.ApiKeys;
import com.example.lostark.repository.ApiKeysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeysService {
    private final ApiKeysRepository apiKeysRepository;

    public ApiKeys findApiKeyByUid(Long uid) {
        return apiKeysRepository.findApiKeysByUid(uid);
    }
}
