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
        Map<String,String> tokenMap=new HashMap<>();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userEmailId", user.getUserEmailId());
        String token = Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "password")
                .compact();
        tokenMap.put("token",token);
        tokenMap.put("message","Login successfully");
        return tokenMap;
    }
}

