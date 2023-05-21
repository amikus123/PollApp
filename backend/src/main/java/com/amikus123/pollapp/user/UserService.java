package com.amikus123.pollapp.user;
import com.amikus123.pollapp.auth.dto.AuthenticationRequest;
import com.amikus123.pollapp.auth.dto.RegisterRequest;
import com.amikus123.pollapp.entities.User;
import com.amikus123.pollapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(RegisterRequest request) throws RuntimeException {
        try {
            Optional<User> userWithSameEmail = userRepository.findByEmail(request.getEmail());
            if(userWithSameEmail.isPresent()){
                throw new RuntimeException("User with this email already exists");
            }
            User user = User.builder().
                    email(request.getEmail())
                    .name(request.getName())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER).build();
            userRepository.save(user);
            return user;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public User getUser(AuthenticationRequest request) throws RuntimeException {
        try {
            User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
            return user;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
