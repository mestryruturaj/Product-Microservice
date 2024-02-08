package com.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class BaseController {
    @GetMapping(value = "")
    public ResponseEntity<String> getHome() {
        return new ResponseEntity<>("Welcome Home", HttpStatus.OK);
    }


}
