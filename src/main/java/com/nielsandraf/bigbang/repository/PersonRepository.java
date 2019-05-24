package com.nielsandraf.bigbang.repository;

import com.nielsandraf.bigbang.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    @Modifying
    @Query("update Person p set p.active= :isActive where p.id= :id")
    void setToPassive(@Param("isActive") boolean isActive, @Param("id") UUID id);
}
