package com.nielsandraf.bigbang.repository;

import com.nielsandraf.bigbang.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartRepository extends JpaRepository<Part, UUID> {
}
