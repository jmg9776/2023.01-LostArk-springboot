package com.example.lostark.service.persist;

import com.example.lostark.model.entity.Market;
import com.example.lostark.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketService<E extends Market> extends DataAccessAbstract<E> {
    private final MarketRepository repository;

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
}
