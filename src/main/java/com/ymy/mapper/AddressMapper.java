package com.ymy.mapper;

import com.ymy.model.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> selectAll();
}