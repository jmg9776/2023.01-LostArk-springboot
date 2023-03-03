package com.example.lostark.config.security;

import com.example.lostark.config.security.jwt.JwtFilter;
import com.example.lostark.config.security.jwt.JwtImpl;
import com.example.lostark.config.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsFilter corsFilter;

    private final JwtImpl jwtImpl;

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilter(corsFilter);
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll();

        http.addFilterBefore(new JwtFilter(new JwtProvider(jwtImpl)), UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement().sessionCreationPolicy((SessionCreationPolicy.STATELESS)); //세션사용안함.
        return http.build();
    }
}
