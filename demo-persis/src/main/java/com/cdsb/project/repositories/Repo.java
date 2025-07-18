package com.cdsb.project.repositories;

import java.util.List;
import java.util.Optional;

public interface Repo<I, E, DTO> {

    List<E> readAll();
    // findAll
    // getAll

    E readById(I id) throws Exception;
    // Optional<E> readById(I id);
    // findById
    // getById

    E create(DTO data);
    // save

    E updateById(I id, E data) throws Exception;
    // update

    E deleteById(I id) throws Exception;
    // delete

}
