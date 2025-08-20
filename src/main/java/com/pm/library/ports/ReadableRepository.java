package com.pm.library.ports;

import java.util.List;
import java.util.Optional;

public interface ReadableRepository<T, ID> {
    Optional<T> findById(ID id);
    Optional<T> findByTitle(String title);
    List<T> findAll();
}
