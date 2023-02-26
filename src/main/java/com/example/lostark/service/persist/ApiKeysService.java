package com.example.lostark.service.persist;

import com.example.lostark.model.entity.ApiKeys;
import com.example.lostark.repository.ApiKeysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiKeysService {
    private final ApiKeysRepository apiKeysRepository;

    public List<String> findApiKeyByUid(Long uid) {
        return apiKeysRepository.findApiKeysByUid(uid);
    }
}
