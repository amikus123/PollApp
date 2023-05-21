package com.amikus123.pollapp.auth;

import com.amikus123.pollapp.auth.dto.AuthenticationRequest;
import com.amikus123.pollapp.auth.dto.RegisterRequest;
import com.amikus123.pollapp.auth.response.AuthenticationResponse;
import com.amikus123.pollapp.utils.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody RegisterRequest request
    ) {
        try {
            return ResponseEntity.ok(authenticationService.register(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody AuthenticationRequest request
    ) {
        try {
            return ResponseEntity.ok(authenticationService.authenticate(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
}
