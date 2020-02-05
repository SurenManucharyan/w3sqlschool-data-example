package com.example.sql.services;

import com.example.sql.model.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

public interface CommonService<E extends BaseEntity> {
    E save(E entity) throws EntityNotFoundException;

    Iterable<E> saveAll(Iterable<E> iterable);

    Iterable<E> listAll();

    Page<E> listAll(Pageable pageable);

    E getById(Integer id) throws EntityNotFoundException;

    E getByIdWithHidden(Integer id) throws EntityNotFoundException;

    void remove(E entity);

    Long count();
}
