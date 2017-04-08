package com.it355.models;

import com.it355.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class InvoiceLine implements Validatable {
    private String itemName;
    private String accountNum;
    private String accountName;
    private int amount;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<>();

        if (ValidationUtils.isEmpty(accountNum)) {
            errors.add(new ValidationError("accountNum", "Please select an Account"));
        }

        if (ValidationUtils.isEmpty(accountName)) {
            errors.add(new ValidationError("accountName", "Please select an Account"));
        }

        if (ValidationUtils.isEmpty(itemName)) {
            errors.add(new ValidationError("itemName", "Please enter an Item Name"));
        }

        if (ValidationUtils.isMaxLength(itemName, 64)) {
            errors.add(new ValidationError("itemName", "Please enter a shorter Item Name"));
        }

        return errors;
    }
}
