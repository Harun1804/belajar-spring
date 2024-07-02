package com.firefly.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Messages {
    @Id
    @Column
    private int id;

    @Column
    private String text;
}
