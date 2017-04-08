package com.it355.controllers.rest;

import com.it355.dao.InvoiceDao;
import com.it355.models.Invoice;
import com.it355.utils.ResponseUtils;
import com.it355.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/invoices")
public class InvoiceRest {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private SessionUtils sessionUtils;
    @Autowired
    private ResponseUtils responseUtils;

    @GetMapping("")
    public ResponseEntity getInvoices() {
        return responseUtils.okResponse("invoices", invoiceDao.findAll(sessionUtils.getUserId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getInvoice(@PathVariable("id") Long id) {
        return responseUtils.okResponse("invoice", invoiceDao.findById(id, sessionUtils.getUserId()));
    }

    @PostMapping(value = "")
    public ResponseEntity createInvoice(@RequestBody Map<String, Invoice> invoiceMap) {
        invoiceMap.get("invoice").setUserId(sessionUtils.getUserId());
        return responseUtils.okResponse("invoice", invoiceDao.insert(invoiceMap.get("invoice")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteInvoice(@PathVariable Long id) {
        invoiceDao.delete(invoiceDao.findById(id, sessionUtils.getUserId()));
        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity updateInvoice(@PathVariable Long id, @RequestBody Map<String, Invoice> invoiceMap) {
        invoiceMap.get("invoice").setId(id);
        invoiceMap.get("invoice").setUserId(sessionUtils.getUserId());
        return responseUtils.okResponse("invoice", invoiceDao.update(invoiceMap.get("invoice")));
    }

}