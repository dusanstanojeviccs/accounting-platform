package com.it355.controllers.rest;

import com.it355.dao.UserDao;
import com.it355.models.User;
import com.it355.models.ValidationError;
import com.it355.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserRest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ResponseUtils responseUtils;

    @GetMapping("")
    public ResponseEntity getUsers() {
        return responseUtils.okResponse("users", userDao.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        return responseUtils.okResponse("user", userDao.findById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity createUser(@RequestBody Map<String, User> userMap) {
        List<ValidationError> errors = new ArrayList<>();

        if (userDao.findByUsername(userMap.get("user").getUsername()).isPresent()) {
            errors.add(new ValidationError("userName", "Username is taken"));
        }

        errors.addAll(userMap.get("user").validate());

        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }
        return responseUtils.okResponse("user", userDao.insert(userMap.get("user")));
    }
}
