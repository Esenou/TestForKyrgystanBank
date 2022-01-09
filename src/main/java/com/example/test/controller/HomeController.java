package com.example.test.controller;

import com.example.test.model.ErrorResponse;
import com.example.test.model.UserModel;
import com.example.test.model.UserPay;
import com.example.test.model.xmlModel.UserModelXml;
import com.example.test.model.xmlModel.UserPayModelXml;
import com.example.test.service.PayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class HomeController {

    private final PayService payService;

    public HomeController(PayService payService) {
        this.payService = payService;
    }


    @GetMapping(value = "/check", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> check(@RequestBody UserModel username) {
        UserModelXml user = payService.check(username);
        if (user != null) {
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        }
        return new ResponseEntity(new ErrorResponse("Not Found User", HttpStatus.NOT_FOUND.toString()), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/pay", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> pay(@RequestBody UserPay model) {
        UserPayModelXml userPayModelXml = payService.pay(model);
        if (userPayModelXml != null) {
            return new ResponseEntity<Object>(userPayModelXml, HttpStatus.OK);
        }
        return new ResponseEntity(new ErrorResponse("Not Found User", HttpStatus.NOT_FOUND.toString()), HttpStatus.NOT_FOUND);
    }
}
