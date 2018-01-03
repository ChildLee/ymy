package com.ymy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ymy.mapper.AdminInfoMapper;
import com.ymy.mapper.AdminMapper;
import com.ymy.model.Admin;
import com.ymy.model.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Test
    public void other() {
        List<AdminInfo> adminInfos = adminInfoMapper.selectAll();
        Iterator<AdminInfo> iterator = adminInfos.iterator();
        while (iterator.hasNext()) {
            AdminInfo next = iterator.next();
            System.out.println(next.toString());
        }
    }

    @Test
    public void Te() {
        Admin admin = new Admin();
        admin.setUsername("31");
        admin.setPassword("2222");
        int login = adminMapper.login(admin);
        System.out.println(login);
    }

    @Test
    public void createToken() throws UnsupportedEncodingException {
        Map<String, Object> header = new HashMap<>();
        header.put(PublicClaims.TYPE, "JWT");
        header.put(PublicClaims.ALGORITHM, "HS256");
        String token = JWT.create()
                .withHeader(header)
                .withClaim("name", "zwz")
                .withClaim("age", "18")
                .sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
    }

    @Test
    public void VerifyToken() throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .build();
        DecodedJWT jwt = verifier.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiend6IiwiYWdlIjoiMTgifQ.UQmqAUhUrpDVV2ST7mZKyLTomVfg7sYkEjmdDI5XF8Q");
        Map<String, Claim> claims = jwt.getClaims();
    }

    @Test
    public void TestToken() throws UnsupportedEncodingException {
        Map<String, Object> header = new HashMap<>();
        String token = JWT.create()
                .withIssuedAt(new Date())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 1))
                .sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .acceptIssuedAt(1)
                .acceptExpiresAt(1)
                .build();
        DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1MTQ5NzA5ODF9.hv4CDwhY7VGj73HbRP4aNBCxVnnnxUi7uudI921LVDs");
    }
}
