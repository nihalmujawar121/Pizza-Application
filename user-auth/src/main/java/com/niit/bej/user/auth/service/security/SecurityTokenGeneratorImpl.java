package com.niit.bej.user.auth.service.security;

import com.niit.bej.user.auth.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", user.getUserName());
        String token = Jwts.builder()
                .setIssuedAt(new Date())
                .setClaims(claims)
                .setSubject(user.getUserName())
                .signWith(SignatureAlgorithm.HS256, "password")
                .compact();
        return Map.of(
                "token", token,
                "message", "Login Successfully"
        );
    }
}

