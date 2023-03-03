package com.example.lostark.config.security.jwt;

import com.example.lostark.config.redis.RedisLimit;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter
{
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        RedisLimit redisLimit = new RedisLimit();
        if (jwtProvider.resolveToken(request) != null) {
            String token = jwtProvider.resolveToken(request);
            try {
                if (jwtProvider.validateToken(token)) {
                    if (redisLimit.limitCheck(token) == false) {
                        UsernamePasswordAuthenticationToken auth = jwtProvider.getAuth(token);
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            } catch (RuntimeException e) {
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
