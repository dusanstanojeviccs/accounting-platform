package com.it355.controllers.rest;
import java.util.List;
import java.util.Map;

import com.it355.dao.BillDao;
import com.it355.models.Bill;
import com.it355.models.ValidationError;
import com.it355.utils.ResponseUtils;
import com.it355.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bills")
public class BillRest {

    @Autowired
    private BillDao billDao;
    @Autowired
    private SessionUtils sessionUtils;
    @Autowired
    private ResponseUtils responseUtils;


    @GetMapping("")
    public ResponseEntity getBills() {
        return responseUtils.okResponse("bills", billDao.findAll(sessionUtils.getUserId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getBill(@PathVariable("id") Long id) {
        return responseUtils.okResponse("bill", billDao.findById(id, sessionUtils.getUserId()));
    }

    @PostMapping(value = "")
    public ResponseEntity createBill(@RequestBody Map<String, Bill> billMap) {
        billMap.get("bill").setUserId(sessionUtils.getUserId());
        List<ValidationError> errors = billMap.get("bill").validate();
        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }
        return responseUtils.okResponse("bill", billDao.insert(billMap.get("bill")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBill(@PathVariable Long id) {
        billDao.delete(billDao.findById(id, sessionUtils.getUserId()));
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBill(@PathVariable Long id, @RequestBody Map<String, Bill> billMap) {
        billMap.get("bill").setId(id);
        billMap.get("bill").setUserId(sessionUtils.getUserId());

        List<ValidationError> errors = billMap.get("bill").validate();

        if (errors.size() > 0) {
            return responseUtils.errorsResponse(errors);
        }
        return responseUtils.okResponse("bill", billDao.update(billMap.get("bill")));
    }

}