package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {

    @GetMapping("/bemvindo")
    public String boasVindas() {
        return "Conexão estabelecida! O Spring Boot está funcionando.";
    }
}
