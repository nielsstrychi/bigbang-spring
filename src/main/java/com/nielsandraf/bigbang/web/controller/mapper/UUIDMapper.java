package com.nielsandraf.bigbang.web.controller.mapper;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDMapper {
    public UUID stringToUUID(String string) {
        return string == null ? null : UUID.fromString(string);
    }

    public String uuidToString(UUID uuid) {
        return uuid == null ? null : uuid.toString();
    }
}