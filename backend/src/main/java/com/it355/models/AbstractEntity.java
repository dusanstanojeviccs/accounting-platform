package com.it355.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class AbstractEntity implements Validatable {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public List<ValidationError> validate() {
        return new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}