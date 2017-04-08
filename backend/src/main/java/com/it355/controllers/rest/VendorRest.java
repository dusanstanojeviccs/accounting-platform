package com.it355.controllers.rest;

import com.it355.dao.VendorDao;
import com.it355.models.ValidationError;
import com.it355.models.Vendor;
import com.it355.utils.ResponseUtils;
import com.it355.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendors")
public class VendorRest {

    @Autowired
    private VendorDao vendorDao;
    @Autowired
    private SessionUtils sessionUtils;
    @Autowired
    private ResponseUtils responseUtils;

    @GetMapping("")
    public ResponseEntity getVendors() {
        return responseUtils.okResponse("vendors", vendorDao.findAll(sessionUtils.getUserId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getVendor(@PathVariable("id") Long id) {
        return responseUtils.okResponse("vendor", vendorDao.findById(id, sessionUtils.getUserId()));
    }

    @PostMapping(value = "")
    public ResponseEntity createVendor(@RequestBody Map<String, Vendor> vendorMap) {
        vendorMap.get("vendor").setUserId(sessionUtils.getUserId());

        List<ValidationError> errors = vendorMap.get("vendor").validate();
        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }

        return responseUtils.okResponse("vendor", vendorDao.insert(vendorMap.get("vendor")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVendor(@PathVariable Long id) {
        vendorDao.delete(vendorDao.findById(id, sessionUtils.getUserId()));
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateVendor(@PathVariable Long id, @RequestBody Map<String, Vendor> vendorMap) {
        vendorMap.get("vendor").setId(id);
        vendorMap.get("vendor").setUserId(sessionUtils.getUserId());

        List<ValidationError> errors = vendorMap.get("vendor").validate();
        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }

        return responseUtils.okResponse("vendor", vendorDao.update(vendorMap.get("vendor")));
    }

}