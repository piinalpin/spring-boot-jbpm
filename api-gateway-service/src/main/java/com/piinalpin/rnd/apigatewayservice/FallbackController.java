package com.piinalpin.rnd.apigatewayservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Slf4j
@RestController
public class FallbackController {

    private ResponseEntity<ErrorDto> getDefaultError() {
        return ResponseEntity.badRequest().body(ErrorDto.builder()
                        .status("ERROR")
                .build());
    }

    @PostMapping(value = "/fallback")
    public ResponseEntity<ErrorDto> fallbackPost() {
        return this.getDefaultError();
    }

    @GetMapping(value = "/fallback")
    public ResponseEntity<ErrorDto> fallbackGet() {
        return this.getDefaultError();
    }

}
