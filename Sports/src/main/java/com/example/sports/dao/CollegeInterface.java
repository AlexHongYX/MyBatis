package com.example.sports.dao;

import com.example.sports.bean.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeInterface {

    List<College> queryCollegeList();
}
