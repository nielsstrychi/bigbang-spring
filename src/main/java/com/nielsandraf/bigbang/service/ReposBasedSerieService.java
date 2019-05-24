package com.nielsandraf.bigbang.service;

import com.nielsandraf.bigbang.model.Serie;
import com.nielsandraf.bigbang.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReposBasedSerieService implements SerieService {

    SerieRepository repo;

    public ReposBasedSerieService(SerieRepository repo) {
        this.repo = repo;
    }

    public Optional<Serie> getSerie(UUID uuid) {
        return repo.findById(uuid);
    }

    public Serie createSerie(Serie dtoToSerie) {
        return repo.save(dtoToSerie);
    }

    public List<Serie> getAll() {
        return repo.findAll();
    }

    public Serie updateSerie(Serie dtoToSerie) {
        return repo.save(dtoToSerie);
    }

    public boolean deleteSerieById(UUID id) {
        Optional<Serie> serie = repo.findById(id);
        if(serie.isPresent()){
            repo.delete(serie.get());
            return true;
        } else return false;
    }
}
