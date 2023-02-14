package com.example.lostark.service.persist;

import com.example.lostark.model.entity.Expedition;
import com.example.lostark.repository.ExpeditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpeditionService<E extends Expedition> extends DataAccessAbstract<E> {
    private final ExpeditionRepository repository;

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

    //Todo : Query tuning
    public List<E> findAllByUid(Long uid) { return (List<E>) repository.findAllByMember_Uid(uid);}
}
