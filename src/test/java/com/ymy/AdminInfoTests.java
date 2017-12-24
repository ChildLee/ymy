package com.ymy;

import com.ymy.mapper.AdminInfoMapper;
import com.ymy.model.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminInfoTests {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Test
    public void selectAdminInfo() {
        AdminInfo adminInfo = adminInfoMapper.getAdminInfo();
        System.out.println(adminInfo.getId());
    }
}
