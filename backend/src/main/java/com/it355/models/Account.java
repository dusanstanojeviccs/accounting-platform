package com.it355.models;

import com.it355.utils.ValidationUtils;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends AbstractEntity {
    private long userId;
    private boolean deleted;
    private AccountType type;
    private String accountNum;
    private String accountName;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<>();


        if (ValidationUtils.isEmpty(accountNum)) {
            errors.add(new ValidationError("accountNum", "Please enter an Account Number"));
        }

        if (ValidationUtils.isEmpty(accountName)) {
            errors.add(new ValidationError("accountName", "Please enter an Account Name"));
        }


        if (ValidationUtils.isMaxLength(accountNum, 64)) {
            errors.add(new ValidationError("accountNum", "Please enter a shorter Account Number"));
        }

        if (ValidationUtils.isMaxLength(accountName, 64)) {
            errors.add(new ValidationError("accountName", "Please enter a shorter Account Name"));
        }

        return errors;
    }
}
