package com.amikus123.pollapp.auth;

import com.amikus123.pollapp.auth.dto.AuthenticationRequest;
import com.amikus123.pollapp.auth.dto.RegisterRequest;
import com.amikus123.pollapp.auth.response.AuthenticationResponse;
import com.amikus123.pollapp.config.JwtService;
import com.amikus123.pollapp.entities.User;
import com.amikus123.pollapp.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private  final UserService userService;
    public AuthenticationResponse register(RegisterRequest request) {
        User user =  userService.createUser(request);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        // if error was not thrown then user should be valid
        User user = userService.getUser(request);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
