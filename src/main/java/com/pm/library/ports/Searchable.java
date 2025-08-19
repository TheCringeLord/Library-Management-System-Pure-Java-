package com.pm.library.ports;

import java.util.List;

public interface Searchable<SPEC, T> {
    List<T> search(SPEC spec);
}