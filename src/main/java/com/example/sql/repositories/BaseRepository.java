package com.example.sql.repositories;

import com.example.sql.model.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Integer> {
    Page<E> findAll(Pageable pageable);
}