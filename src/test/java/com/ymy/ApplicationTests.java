package com.ymy;

import com.ymy.mapper.AdminInfoMapper;
import com.ymy.mapper.AdminMapper;
import com.ymy.model.Admin;
import com.ymy.model.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void Da() {

    }
}
