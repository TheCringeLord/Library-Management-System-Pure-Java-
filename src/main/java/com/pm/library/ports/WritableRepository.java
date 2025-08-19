package com.pm.library.ports;


public interface WritableRepository<T, ID> {
    T save(T entity);
    boolean deleteById(ID id);
}
