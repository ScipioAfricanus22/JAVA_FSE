package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    
    // Generate a secure signing key for HMAC-SHA256
    private static final Key SIGNING_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        LOGGER.info("START - Authentication endpoint triggered");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization Header credentials.");
        }

        // 1. Decode Authorization header values
        String base64Credentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
        
        // Split username and password using colon delimiter
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        LOGGER.debug("Extracted User Credentials from Request -> Username: {}", username);

        // 2. Simple credential check (Mirroring user:pwd requirement)
        if (!"user".equals(username) || !"pwd".equals(password)) {
            throw new RuntimeException("Invalid username or password match.");
        }

        // 3. Generate Secure Signed JWT
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiryDate = new Date(nowMillis + 3600000); // 1-hour duration window

        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SIGNING_KEY)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);

        LOGGER.info("END - Authentication token generation complete");
        return response;
    }
}
