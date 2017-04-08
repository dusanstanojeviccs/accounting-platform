package com.it355.utils;

import com.it355.models.Validatable;
import com.it355.models.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Component
public class ResponseUtils {
    public ResponseEntity errorsResponse(List<ValidationError> errors) {
        Map<String, Object> response = new HashMap<>();

        response.put("errors", errors);

        return new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity errorsResponse(ValidationError... errors) {
        Map<String, Object> response = new HashMap<>();

        response.put("errors", Arrays.asList(errors));

        return new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity okResponse(String key, Object value) {
        Map<String, Object> response = new HashMap<>();

        response.put(key, value);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    public ResponseEntity validateAndRespond(String key, Validatable value) {
        List<ValidationError> errors = value.validate();
        Map<String, Object> response = new HashMap<>();

        if (errors.size() == 0) {
            response.put(key, value);
        } else {
            response.put("errors", errors);
        }

        return new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
