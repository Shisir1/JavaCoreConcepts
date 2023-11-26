package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTTokenGenerator {
    public static void main(String[] args) {

        String secretKey = "mysecretkeyforJWTandbearertokenpractice47849klngkjahioq9u43pifnkleajjfdksaljfkalhjakhlf987";

        //sample payload data
        Claims claims = Jwts.claims()
                .setSubject("Shisir Humagain")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)); //token expires in 1 hour

        //create a JWT token
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        String bearerToken = "Bearer " + token;

        System.out.println("Bearer Token : " + bearerToken);
        System.out.println("Issued at: " + claims.getIssuedAt());
        System.out.println("Expires at: "+claims.getExpiration());
        System.out.println(claims.getSubject());
    }
}