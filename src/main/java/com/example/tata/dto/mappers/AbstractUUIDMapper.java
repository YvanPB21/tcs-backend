package com.example.tata.dto.mappers;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class AbstractUUIDMapper {

    public UUID map(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

    public String map(UUID id) {
        return id != null ? String.valueOf(id).toUpperCase() : null;
    }
}
