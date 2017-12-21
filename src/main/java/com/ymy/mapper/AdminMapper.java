package com.ymy.mapper;

import com.ymy.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin getAdmin();
}
