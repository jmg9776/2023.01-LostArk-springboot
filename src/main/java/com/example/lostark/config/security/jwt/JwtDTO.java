package com.example.lostark.config.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtDTO {
    private String accessToken;
    private String refreshToken;
}
