package com.dhia.pfemanager.pfemanager.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class jwtService {

    private static final String SECRET_KEY = "KxDDObvzXzDi+SQdazKW14pv9HQIQfivBdEHxxzaNFTKVqZjmaGUQsQ6si9u4J1Y3a02/X9M0+j+3bxXlG6rYaO9glQGKm7CWsL4ms598XIpbFRSs9fR/4ybg6Ar0yiVCysORfeh7VctAEGd3pDZ7uhpiVAuhiqiETSSIYRBYhGsADrj/+vrtYkycWTcOyAqw5guu/kOzNCzJDbBkKGFdLTp4imC7UdNpLUIt2QYcbSUg6p70zk19bNW0U5bIfZ4GEs8o12tJARXXOmi9qocxe6XjJ1hGsdxRj/usJiVY4w1qVFVr3A2KczwLMVhSsYUIuxczt2PYaVEUQuJONgVIsHBl4zc6YuBZn/jeQUls0Q=";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T>claimResolver){
        final Claims claims =extraxtAllClaims(token);
        return claimResolver.apply(claims);
    }


    public String generateToken(
            UserDetails userDetails
    ){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extraxtAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
