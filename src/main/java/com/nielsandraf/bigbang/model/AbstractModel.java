package com.nielsandraf.bigbang.model;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
