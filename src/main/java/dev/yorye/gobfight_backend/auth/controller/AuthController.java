package dev.yorye.gobfight_backend.auth.controller;

import dev.yorye.gobfight_backend.auth.dto.RegisterRequest;
import dev.yorye.gobfight_backend.auth.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/regiter")
    public ResponseEntity<TokenResponse> register(@RequestBody final RegisterRequest request) {
        final TokenResponse token = new TokenResponse(); // llamar al servicio orquestador
        return ResponseEntity.ok(token);
    }

    //@PostMapping("/login")
    //

    //@PostMapping("/logout") Creo que no es necesario porque si se borra el Token desde el forntal la sesion se pierde

    //@PostMapping("/refresh/token")
}
