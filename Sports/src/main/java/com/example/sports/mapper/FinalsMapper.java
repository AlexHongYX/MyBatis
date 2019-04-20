package com.example.sports.mapper;

import com.example.sports.pojo.Finals;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FinalsMapper {

    @Select("select * from finals")
    List<Finals> getFinalses();

    @Select("select * from finals where fin_id=#{id}")
    Finals getFinalsById(String id);
}
