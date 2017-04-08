package com.it355.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    private String username;
    @JsonIgnore private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<>();

        return errors;
    }
}
