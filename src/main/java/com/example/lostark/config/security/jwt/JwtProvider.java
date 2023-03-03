package com.example.lostark.config.security.jwt;

import com.example.lostark.model.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Component
@Getter
@RequiredArgsConstructor
public class JwtProvider {
    private final String key = "test";

    private Long accessTokenLimit;

    private Long refreshTokenLimit;
    private final UserDetailsService userDetailsService;

    public JwtDTO creatToken(String accessToken, String refreshToken) {
        return JwtDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            throw new RuntimeException("Token Error");
        }
    }

    public UsernamePasswordAuthenticationToken getAuth(String token) {
        String id = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(id);
        return new UsernamePasswordAuthenticationToken(userDetails, "" , userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String createAccessToken(Member member) {
        return createJwt(member, accessTokenLimit);
    }

    public String createRefreshToken(Member member) {
        return createJwt(member, accessTokenLimit);
    }

    private String createJwt(Member member, Long timeLimit) {
        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(member.getId());
        String Jwt = Jwts.builder()
                .setHeader(createHeader())
                .setClaims(claims)
                .setExpiration(new Date(now.getTime() + timeLimit))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
        return Jwt;
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }
}
