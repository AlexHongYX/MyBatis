package com.example.sports.service;

import com.example.sports.mapper.AthletesMapper;
import com.example.sports.pojo.Athletes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthletesService {

    @Autowired
    private AthletesMapper athletesMapper;

    public List<Athletes> queryData() {
        return athletesMapper.queryData();
    }

    public Integer getCount(){
        return athletesMapper.getCount();
    }

    public List<Athletes> queryDataByName(String name){
        return athletesMapper.queryDataByName(name);
    }

    public List<Athletes> queryDataById(String queryText) {
        return athletesMapper.queryDataById(queryText);
    }

    public List<Athletes> queryDataByIn(String [] arr){
        return athletesMapper.queryDataByIn(arr);
    }


    public List<Athletes> queryDataByCollegeId(String collegeId){
        return  athletesMapper.queryDataByCollegeId(collegeId);
    }
}
