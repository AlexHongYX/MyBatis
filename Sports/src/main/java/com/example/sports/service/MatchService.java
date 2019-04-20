package com.example.sports.service;

import com.example.sports.mapper.MatchMapper;
import com.example.sports.pojo.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MatchService {

    @Autowired
    private MatchMapper matchMapper;

    public List<Match> queryData(Map<String,Object> map){
        return  matchMapper.queryData(map);
    }

    public Integer getCount(Map<String,Object> map){
        return matchMapper.getCount(map);
    }
}
