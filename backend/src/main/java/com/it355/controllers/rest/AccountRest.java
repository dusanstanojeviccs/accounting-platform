package com.it355.controllers.rest;
import java.util.List;
import java.util.Map;

import com.it355.dao.AccountDao;
import com.it355.models.Account;
import com.it355.models.ValidationError;
import com.it355.utils.ResponseUtils;
import com.it355.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts")
public class AccountRest {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private SessionUtils sessionUtils;
    @Autowired
    private ResponseUtils responseUtils;


    @GetMapping("")
    public ResponseEntity getAccounts() {
        return responseUtils.okResponse("accounts", accountDao.findAll(sessionUtils.getUserId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAccount(@PathVariable("id") Long id) {
        return responseUtils.okResponse("account", accountDao.findById(id, sessionUtils.getUserId()));
    }

    @PostMapping(value = "")
    public ResponseEntity createAccount(@RequestBody Map<String, Account> accountMap) {
        accountMap.get("account").setUserId(sessionUtils.getUserId());
        List<ValidationError> errors = accountMap.get("account").validate();
        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }
        return responseUtils.okResponse("account", accountDao.insert(accountMap.get("account")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        accountDao.delete(accountDao.findById(id, sessionUtils.getUserId()));
        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Map<String, Account> accountMap) {
        accountMap.get("account").setId(id);
        accountMap.get("account").setUserId(sessionUtils.getUserId());
        List<ValidationError> errors = accountMap.get("account").validate();
        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }
        return responseUtils.okResponse("account", accountDao.update(accountMap.get("account")));
    }

}