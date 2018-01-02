package com.ymy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        String token = JWT.create()
                .withHeader(header)//header
                .withClaim("name", "zwz")//payload
                .withClaim("age", "18")
                .sign(Algorithm.HMAC256("secret"));//加密
        System.out.println(token);
    }

    @Test
    public void VerifyToken() throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .build();
        DecodedJWT jwt = verifier.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiend6IiwiYWdlIjoiMTgifQ.UQmqAUhUrpDVV2ST7mZKyLTomVfg7sYkEjmdDI5XF8Q");
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("name").asString());
        System.out.println(claims.get("age").asString());
    }

    @Test
    public void DecodeToken() {
        DecodedJWT jwt = JWT.decode("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCJ9.izVguZPRsBQ5Rqw6dhMvcIwy8_9lQnrO3vpxGwPCuzs");
        String header = jwt.getHeader();
        String payload = jwt.getPayload();
        String signature = jwt.getSignature();
        System.out.println(header);
        System.out.println(payload);
        System.out.println(signature);
    }
}
