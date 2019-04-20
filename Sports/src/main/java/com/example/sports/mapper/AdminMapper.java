package com.example.sports.mapper;

import com.example.sports.pojo.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {

    @Select("select * from admin ")
    List<Admin> getAdmins();
}
