package com.example.lostark.service.persist;

import com.example.lostark.repository.ApiKeysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiKeysService {
    private final ApiKeysRepository apiKeysRepository;
}
