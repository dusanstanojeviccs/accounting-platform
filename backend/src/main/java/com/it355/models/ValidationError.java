package com.it355.models;

import java.util.Map;
import java.util.HashMap;

public class ValidationError {

    public String detail;
    public Map<String, String> source;

    public ValidationError(String attribute, String detail) {
        this.detail = detail;

        source = new HashMap<>();
        source.put("pointer", "data/attributes/"+attribute);
    }
}
