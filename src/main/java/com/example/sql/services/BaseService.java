package com.example.sql.services;

import com.example.sql.model.entity.BaseEntity;
import com.example.sql.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

public abstract class BaseService<E extends BaseEntity, R extends BaseRepository<E>> implements CommonService<E> {

    private final R repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public BaseService(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E model) throws EntityNotFoundException {
        return repository.save(model);
    }

    @Override
    public Iterable<E> saveAll(Iterable<E> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    public Iterable<E> listAll() {
        return repository.findAll();
    }

    @Override
    public Page<E> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public E getById(Integer id) throws EntityNotFoundException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public E getByIdWithHidden(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void remove(E entity) {
        repository.delete(entity);
    }

    @Override
    public Long count() {
        return repository.count();
    }
}