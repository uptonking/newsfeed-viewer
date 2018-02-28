package io.yaoo.test;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TESTJWT {

    public static void main(String[] args) {

        // secret
        String secret = "secret-seeds";
        JWTSignVerify jwt = new JWTSignVerify(secret);

        // payload
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", "yaooxx");

        // expiration
        Date expiration = new Date(System.currentTimeMillis() + 4 * 60 * 1000);

        // sign
        String token = jwt.sign(payload, expiration);
        System.out.println(token);

        // verify
        Claims claims = jwt.verify(token);
        System.out.println(claims.toString());
    }
}