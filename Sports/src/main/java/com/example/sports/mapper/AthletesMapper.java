package com.example.sports.mapper;

import com.example.sports.pojo.Athletes;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AthletesMapper {

    //与College联合查询
    @Select("select ath.*,col.col_name as college_name from athletes ath,college col where ath.ath_college=col.col_id")
    List<Athletes> queryData();

    @Select("select count(1) from athletes ")
    Integer getCount();

    //根据名称模糊查询与College联合查询
    @Select("SELECT ath.*,col.col_name as college_name FROM athletes ath,college col WHERE ath.ath_college=col.col_id and ath.ath_name like CONCAT('%',#{name},'%')")
    List<Athletes> queryDataByName(String name);

    //根据主键模糊查询与College联合查询
    @Select("SELECT ath.*,col.col_name as college_name FROM athletes ath,college col WHERE ath.ath_college=col.col_id and ath.ath_id like CONCAT('%',#{id},'%') ")
    List<Athletes> queryDataById(String id);

    //in查询
    List<Athletes> queryDataByIn(String [] arr);

    //根据外键查询
    @Select("SELECT ath.*,col.col_name as college_name FROM athletes ath,college col WHERE ath.ath_college=col.col_id and ath.ath_college=#{collegeId} ")
    List<Athletes> queryDataByCollegeId(String collegeId);
}
