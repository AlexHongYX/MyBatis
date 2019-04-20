package com.example.sports.mapper;

import com.example.sports.pojo.College;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollegeMapper {

    @Select("select * from college")
    List<College> getColleges();

    //根据分数排序
    @Select("select * from college order by col_integral DESC")
    List<College> getCollegesOrder();




}
