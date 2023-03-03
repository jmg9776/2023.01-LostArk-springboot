package com.example.lostark.config.security.jwt;

import com.example.lostark.model.entity.Member;
import com.example.lostark.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JwtImpl implements UserDetailsService
{
    final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member account = memberRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("cannot find id"));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new org
                .springframework.security.core.userdetails.User(account.getId(), account.getPw(), grantedAuthorities);
    }
}
