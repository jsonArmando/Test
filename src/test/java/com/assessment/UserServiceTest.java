package com.assessment;

import com.assessment.entities.User;
import com.assessment.repositories.UserRepository;
import com.assessment.services.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_Success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("Password1@");

        when(userRepository.existsByEmail(anyString())).thenReturn(false);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.registerUser(user);

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void registerUser_EmailAlreadyExists() {
        User user = new User();
        user.setEmail("existing@example.com");
        user.setPassword("Password1@");

        when(userRepository.existsByEmail(anyString())).thenReturn(true);

        assertThrows(RuntimeException.class, () -> userService.registerUser(user));
    }

    @Test
    void registerUser_InvalidEmail() {
        User user = new User();
        user.setEmail("invalid-email");
        user.setPassword("Password1@");

        assertThrows(RuntimeException.class, () -> userService.registerUser(user));
    }

    @Test
    void registerUser_InvalidPassword() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("weak");

        assertThrows(RuntimeException.class, () -> userService.registerUser(user));
    }
}