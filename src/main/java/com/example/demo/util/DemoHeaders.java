package com.example.demo.util;

import com.example.demo.common.EnumResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DemoHeaders extends HttpHeaders{

    public DemoHeaders(EnumResult result, String mediaType) {
        super(setHeaders(result, mediaType));
    }
    public DemoHeaders(EnumResult result) {
        super(setHeaders(result, null));
    }

    private static HttpHeaders setHeaders(EnumResult result, String mediaType) {
        final String RESULT_CODE_NAME = "Server-Result-Code";
        final String RESULT_MESSAGE_NAME = "Server-Result-Message";

        Map<String, String> header = new HashMap<>();
        header.put(RESULT_CODE_NAME, result.getCd());
        header.put(RESULT_MESSAGE_NAME, result.getMsg());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(mediaType != null ? mediaType : MediaType.APPLICATION_JSON_VALUE));

        for (String key : header.keySet()) {
            headers.set(key, String.valueOf(header.get(key)));
        }
        return headers;
    }
}
