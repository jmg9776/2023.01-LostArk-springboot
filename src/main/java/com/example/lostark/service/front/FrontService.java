package com.example.lostark.service.front;

import com.example.lostark.model.result.RestResultBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class FrontService {
    protected final RestResultBuilder resultBuilder = new RestResultBuilder();
}
