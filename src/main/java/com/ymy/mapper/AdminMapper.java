package com.ymy.mapper;

import com.ymy.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    /**
     * 添加管理员
     *
     * @param admin 要添加的信息
     * @return 是否添加成功
     */
    int addAdmin(Admin admin);

    /**
     * 删除管理员
     *
     * @param id 管理员ID
     * @return 是否删除成功
     */
    int deleteAdmin(Integer id);

    /**
     * 修改管理员信息
     *
     * @param admin 要修改的信息
     * @return 是否修改成功
     */
    int updateAdmin(Admin admin);

    /**
     * 根据ID查询管理员
     *
     * @param id
     * @return 查询的管理员
     */
    Admin selectAdmin(Integer id);

    /**
     * 查询所有的管理员
     *
     * @return 所有管理员
     */
    List<Admin> selectAdminAll();

    /**
     * 管理员登录
     *
     * @param admin 账号密码
     * @return 管理员Id
     */
    Integer login(Admin admin);

    /**
     * 根据用户ID查询token
     *
     * @param id 用户Id
     * @return 返回Token
     */
    String selectToken(Integer id);
}