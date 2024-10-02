package com.assessment;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.assessment.security.JwtUtil;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        ReflectionTestUtils.setField(jwtUtil, "secret", "testSecretKeyWithAtLeast256BitsForHMACSHA256Algorithm");
        ReflectionTestUtils.setField(jwtUtil, "expiration", 3600000L);
    }

    @Test
    void generateTokenAndValidate() {
        String username = "test@example.com";
        String token = jwtUtil.generateToken(username);

        assertNotNull(token);
        assertTrue(jwtUtil.validateToken(token, username));
    }

    @Test
    void extractUsername() {
        String username = "test@example.com";
        String token = jwtUtil.generateToken(username);

        assertEquals(username, jwtUtil.extractUsername(token));
    }

    @Test
    void extractExpiration() {
        String token = jwtUtil.generateToken("test@example.com");
        assertNotNull(jwtUtil.extractExpiration(token));
    }
}
