package com.example.sports.service;

import com.example.sports.mapper.CollegeMapper;
import com.example.sports.pojo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    public List<College> getColleges() {
        return collegeMapper.getColleges();
    }

    public List<College> getCollegesOrder(){
        return collegeMapper.getCollegesOrder();
    }
}
