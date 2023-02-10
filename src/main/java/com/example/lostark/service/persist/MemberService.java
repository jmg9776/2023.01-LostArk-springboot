package com.example.lostark.service.persist;

import com.example.lostark.model.entity.Member;
import com.example.lostark.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService<E extends Member> extends DataAccessAbstract<E> {
    private final MemberRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public E save(E member) {
        Optional<Member> accountOptional = repository.findById(member.getId());
        if(accountOptional.isEmpty()){
            String password = member.getPw();
            member.setPw(bCryptPasswordEncoder.encode(password));
            return repository.save(member);
        }
        else {
            throw new RuntimeException(member.getId() + " is already exist");
        }
    }

    @Override
    public List<E> saveAll(List<E> data) {
        return repository.saveAll(data);
    }

    @Override
    public Optional<E> findById(Long id) {
        return (Optional<E>) repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return (List<E>) repository.findAll();
    }
}
