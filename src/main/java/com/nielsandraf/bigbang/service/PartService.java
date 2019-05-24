package com.nielsandraf.bigbang.service;

import com.nielsandraf.bigbang.model.Part;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartService {

     Optional<Part> getPartbyId(UUID uuid);

     Part create(Part dtoToPart);

     List<Part> getAll();

     Part update(Part dtoToPart);

     boolean deletePartById(UUID id);
}
