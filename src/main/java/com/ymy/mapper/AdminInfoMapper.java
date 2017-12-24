package com.ymy.mapper;

import com.ymy.model.AdminInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInfoMapper {

    /**
     * @return
     */
    AdminInfo getAdminInfo();

}
