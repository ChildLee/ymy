package com.ymy;

import com.ymy.mapper.AdminMapper;
import com.ymy.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void other() {
        Admin admin = new Admin();
        admin.setUsername("sa");
        admin.setPassword("sa");
        admin.setLevel(0);
        admin.setStatus((byte) 0);
        Integer a = adminMapper.insert(admin);
        System.out.println(a);
    }

}
