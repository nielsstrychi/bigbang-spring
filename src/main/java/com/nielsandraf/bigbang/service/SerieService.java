package com.nielsandraf.bigbang.service;

import com.nielsandraf.bigbang.model.Serie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SerieService {

     Optional<Serie> getSerie(UUID uuid);

     Serie createSerie(Serie dtoToSerie);

     List<Serie> getAll();

     Serie updateSerie(Serie dtoToSerie);

     boolean deleteSerieById(UUID id);

    }