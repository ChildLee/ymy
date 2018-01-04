package com.ymy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
        String token = JWT.create()
                .withClaim("name", "zwz")
                .withClaim("age", "18")
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("secret"));
        System.out.println(token);
    }

    @Test
    public void VerifyToken() throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
                .build();
        DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiend6IiwiaWF0IjoxNTE1MDUxMTUzLCJhZ2UiOiIxOCJ9.20KRztrp7OMPeg7ksjBdg2cF0cihHO06sU88aM3XzIU");
        System.out.println(jwt.getClaims().get("name").asString());
        System.out.println(jwt.getClaim("name").asString());
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.sss");
        System.out.println(format.format(jwt.getIssuedAt().getTime()));
    }
}