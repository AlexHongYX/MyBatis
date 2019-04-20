package com.example.sports.mapper;

import com.example.sports.pojo.Match;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MatchMapper {

    //分页测试
    @Select("select * from `match` limit #{startIndex},#{pageSize}")
    List<Match> queryData(Map<String,Object> map);

    @Select("select count(1) from `match`")
    Integer getCount(Map<String,Object> map);


}
