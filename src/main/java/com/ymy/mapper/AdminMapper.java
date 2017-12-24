package com.ymy.mapper;

import com.ymy.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {


    /**
     * 查询所有管理员
     *
     * @return 管理员集合
     */
    List<Admin> getAdmin();

    Boolean deleteAdmin(Admin admin);

    /**
     * 添加管理员
     *
     * @param admin 添加的信息
     * @return 添加成功后返回1
     */
    Boolean addAdmin(Admin admin);

    /**
     * 更改管理员
     *
     * @param admin 添加的信息
     * @return 添加成功后返回1
     */
    Boolean updateAdmin(Admin admin);
}
