package com.it355.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it355.utils.ValidationUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Bill extends AbstractEntity {
    private long userId;
    private boolean deleted;
    private String vendorName;
    private String payeeName;
    private String payeeEmail;
    private String phoneNumber;
    private Date creationDate;
    private Date dueDate;

    @Transient private List<BillLine> lines = new ArrayList<>();

    @JsonIgnore private String itemName;
    @JsonIgnore private String accountName;
    @JsonIgnore private String accountNumber;
    @JsonIgnore private String amount;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPayeeEmail(String payeeEmail) {
        this.payeeEmail = payeeEmail;
    }

    public List<BillLine> getLines() {
        return lines;
    }

    public void setLines(List<BillLine> lines) {
        this.lines = lines;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Bill explode() {
        if (itemName.equals("")) {
            return this;
        }

        lines = new ArrayList<>();

        String[] itemNameArr    = itemName.split("\\^", -1);
        String[] accountNumArr  = accountNumber.split("\\^", -1);
        String[] accountNameArr = accountName.split("\\^", -1);
        String[] amtArr         = amount.split("\\^", -1);

        BillLine billLine;

        for (int i=0; i<itemNameArr.length; i++) {
            billLine = new BillLine();

            billLine.setItemName(itemNameArr[i]);
            billLine.setAccountNum(accountNumArr[i]);
            billLine.setAccountName(accountNameArr[i]);
            billLine.setAmount(Integer.valueOf(amtArr[i]));

            lines.add(billLine);
        }

        return this;
    }

    public Bill implode() {
        StringBuilder sbItemName = new StringBuilder();
        StringBuilder sbAccountNumber = new StringBuilder();
        StringBuilder sbAccountName = new StringBuilder();
        StringBuilder sbAmt = new StringBuilder();

        int size = lines.size();
        BillLine billLine;

        String separator;
        for (int i=0; i<size; i++) {
            billLine = lines.get(i);

            separator = (i == size - 1) ? "" : "^";

            sbItemName.append(billLine.getItemName());
            sbItemName.append(separator);

            sbAccountNumber.append(billLine.getAccountNum());
            sbAccountNumber.append(separator);

            sbAccountName.append(billLine.getAccountName());
            sbAccountName.append(separator);

            sbAmt.append(billLine.getAmount());
            sbAmt.append(separator);
        }

        itemName = sbItemName.toString();
        accountNumber = sbAccountNumber.toString();
        accountName = sbAccountName.toString();
        amount = sbAmt.toString();

        return this;
    }


    @Override
    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<>();

        if (ValidationUtils.isEmpty(vendorName)) {
            errors.add(new ValidationError("vendorName", "Please enter a valid Vendor"));
        }

        if (ValidationUtils.isNull(creationDate)) {
            errors.add(new ValidationError("creationDate", "Please enter a Creation Date"));
        }

        if (ValidationUtils.isNull(dueDate)) {
            errors.add(new ValidationError("dueDate", "Please enter a Due Date"));
        }

        lines.forEach(line -> errors.addAll(line.validate()));

        return errors;
    }
}
