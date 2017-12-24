package com.ymy;

import com.ymy.mapper.AdminMapper;
import com.ymy.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTests {
    @Autowired
    AdminMapper adminMapper;

    @Test
    public void addAdmin() {
        Admin admin = new Admin();
        admin.setUsername("sa");
        admin.setPassword("sa");
        admin.setLevel((long) 0);
        admin.setStatus((byte) 11);
        Boolean a = adminMapper.addAdmin(admin);
        System.out.println(a);
    }

    @Test
    public void deleteAdmin() {
        Admin admin = new Admin();
        admin.setId((long) 3);
        Boolean a = adminMapper.deleteAdmin(admin);
        System.out.println(a);
    }

    @Test
    public void updateAdmin() {
        Admin admin = new Admin();
        admin.setId((long) 3);
        admin.setUsername("sa");
        admin.setPassword("aa");
        admin.setCreateTime(new Timestamp(System.currentTimeMillis()));
        admin.setLevel((long) 0);
        admin.setStatus((byte) 0);
        Boolean a = adminMapper.updateAdmin(admin);
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(a);
    }

    @Test
    public void selectAdminAll() {
        List<Admin> list = adminMapper.getAdmin();
        Iterator<Admin> iterator = list.iterator();
        while (iterator.hasNext()) {
            Admin admin = iterator.next();
            System.out.println(admin);
        }
    }


}
