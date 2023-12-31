package com.example.proj.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.time.OffsetDateTime;

@MappedSuperclass
public class BaseEntity {
    private OffsetDateTime createdDate;

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = OffsetDateTime.now();
    }
}
