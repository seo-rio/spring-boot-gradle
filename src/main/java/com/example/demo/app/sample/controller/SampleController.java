package com.example.demo.app.sample.controller;

import com.example.demo.app.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class SampleController {

    private final SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/sample", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sample() {

        log.debug("TEST");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("TEST", "HI");

        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
