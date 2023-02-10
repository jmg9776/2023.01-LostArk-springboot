package com.example.lostark.service.persist;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class DataAccessAbstract<E> {
    public abstract E save(E data);
    public abstract List<E> saveAll(List<E> data);
    public abstract Optional<E> findById(Long id);
    public abstract List<E> findAll();
}
