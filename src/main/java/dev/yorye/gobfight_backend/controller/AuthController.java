package dev.yorye.gobfight_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/regiter")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("Register");
    }

}
