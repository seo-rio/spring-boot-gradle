package com.example.demo.app.sample.controller;

import com.example.demo.app.sample.model.SampleModel;
import com.example.demo.app.sample.service.SampleService;
import com.example.demo.common.EnumResult;
import com.example.demo.util.DemoHeaders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "Swagger Sample Controller")
@RestController
@Slf4j
public class SampleController {

    private final SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }

    @ApiOperation(value = "Sample", notes = "샘플 API")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(value = "/api/sample")
    public ResponseEntity<Object> sample() {

        log.debug("TEST");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("TEST", "HI");

        ResponseEntity res = new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        return res;
    }

    @ApiOperation(value = "Sample2", notes = "샘플 API2")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(value = "/api/sample2")
    public Map<String, Object> sample2() {

        log.debug("TEST");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("TEST", "HI");

        return result;
    }

    @ApiOperation(value = "Sample3", notes = "샘플 API3")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server Error"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(value = "/api/sample3")
    public ResponseEntity<SampleModel> sample3() {
        SampleModel model = new SampleModel();
        model.setId(9999);
        model.setName("안녕!!");
        return ResponseEntity.ok().headers(new DemoHeaders(EnumResult.SUCCESS)).body(model);
    }
}
