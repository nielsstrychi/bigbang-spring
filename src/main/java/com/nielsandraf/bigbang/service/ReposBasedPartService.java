package com.nielsandraf.bigbang.service;

import com.nielsandraf.bigbang.model.Part;
import com.nielsandraf.bigbang.repository.PartRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReposBasedPartService implements PartService {

    PartRepository repo;

    public ReposBasedPartService(PartRepository repo) {
        this.repo = repo;
    }

    public Optional<Part> getPartbyId(UUID uuid) {
        return repo.findById(uuid);
    }

    public Part create(Part dtoToPart) {
        return repo.save(dtoToPart);
    }

    public List<Part> getAll() {
        return repo.findAll();
    }

    public Part update(Part dtoToPart) {
        return repo.save(dtoToPart);
    }

    public boolean deletePartById(UUID id) {
        Optional<Part> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.delete(optional.get());
            return true;
        } else return false;
    }
}
