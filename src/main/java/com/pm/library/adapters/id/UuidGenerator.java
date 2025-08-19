package com.pm.library.adapters.id;

import com.pm.library.ports.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {
    @Override
    public String newId() {
        return UUID.randomUUID().toString();
    }
}
