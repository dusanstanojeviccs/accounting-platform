package com.it355.models;

import java.util.List;

public interface Validatable {
    List<ValidationError> validate();
}

