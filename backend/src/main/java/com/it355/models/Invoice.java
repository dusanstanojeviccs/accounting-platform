package com.it355.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.it355.utils.ValidationUtils;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice extends AbstractEntity implements Validatable {
    private long userId;
    private boolean deleted;
    private String vendorName;
    private String payeeName;
    private String payeeEmail;
    private String phoneNumber;
    private Date creationDate;
    private Date dueDate;

    @Transient private List<InvoiceLine> lines = new ArrayList<>();

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


    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
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


    public Invoice explode() {
        if (itemName.equals("")) {
            return this;
        }

        lines = new ArrayList<>();

        String[] itemNameArr    = itemName.split("\\^", -1);
        String[] accountNumArr  = accountNumber.split("\\^", -1);
        String[] accountNameArr = accountName.split("\\^", -1);
        String[] amtArr         = amount.split("\\^", -1);

        InvoiceLine invoiceLine;

        for (int i=0; i<itemNameArr.length; i++) {
            invoiceLine = new InvoiceLine();

            invoiceLine.setItemName(itemNameArr[i]);
            invoiceLine.setAccountNum(accountNumArr[i]);
            invoiceLine.setAccountName(accountNameArr[i]);
            invoiceLine.setAmount(Integer.valueOf(amtArr[i]));

            lines.add(invoiceLine);
        }

        return this;
    }

    public Invoice implode() {
        StringBuilder sbItemName = new StringBuilder();
        StringBuilder sbAccountNumber = new StringBuilder();
        StringBuilder sbAccountName = new StringBuilder();
        StringBuilder sbAmt = new StringBuilder();

        int size = lines.size();

        String separator;
        for (int i=0; i<size; i++) {
            InvoiceLine invoiceLine = lines.get(i);

            separator = (i == size - 1) ? "" : "^";

            sbItemName.append(invoiceLine.getItemName());
            sbItemName.append(separator);

            sbAccountNumber.append(invoiceLine.getAccountNum());
            sbAccountNumber.append(separator);

            sbAccountName.append(invoiceLine.getAccountName());
            sbAccountName.append(separator);

            sbAmt.append(invoiceLine.getAmount());
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

        if (ValidationUtils.isNull(dueDate)) {
            errors.add(new ValidationError("dueDate", "Please enter a Due Date"));
        }

        if (ValidationUtils.isNull(creationDate)) {
            errors.add(new ValidationError("creationDate", "Please enter a Creation Date"));
        }

        lines.forEach(line -> errors.addAll(line.validate()));

        return errors;
    }
}
