package com.example.lostark.service.persist;

import com.example.lostark.model.entity.CharacterInfo;
import com.example.lostark.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterInfoService <E extends CharacterInfo> extends DataAccessAbstract<E> {
    private final CharacterRepository repository;

    @Override
    public E save(E data) {
        return repository.save(data);
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

    public Optional<E> findByCharacterName(String characterName) {
        return (Optional<E>) repository.findCharacterInfoByCharacterName(characterName);
    }
}
