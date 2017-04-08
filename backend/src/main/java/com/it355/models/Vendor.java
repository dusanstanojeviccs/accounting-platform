package com.it355.models;

import com.it355.utils.ValidationUtils;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendor extends AbstractEntity {
    private long userId;
    private boolean deleted;
    private String vendorName;
    private String payeeName;
    private String payeeEmail;
    private String phoneNumber;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeEmail() {
        return payeeEmail;
    }

    public void setPayeeEmail(String payeeEmail) {
        this.payeeEmail = payeeEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

        if (ValidationUtils.isEmpty(vendorName)) {
            errors.add(new ValidationError("vendorName", "Please enter a Vendor/Customer Name"));
        }

        if (ValidationUtils.isEmpty(payeeName)) {
            errors.add(new ValidationError("payeeName", "Please enter a Payee Name"));
        }

        if (ValidationUtils.isMaxLength(vendorName, 64)) {
            errors.add(new ValidationError("vendorName", "Please enter a shorter Vendor Name"));
        }

        if (ValidationUtils.isMaxLength(payeeName, 64)) {
            errors.add(new ValidationError("payeeName", "Please enter a shorter Payee Name"));
        }
        return errors;
    }
}
