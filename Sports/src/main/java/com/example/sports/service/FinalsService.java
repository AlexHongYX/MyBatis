package com.example.sports.service;

import com.example.sports.mapper.FinalsMapper;
import com.example.sports.pojo.Finals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalsService {

    @Autowired
    private FinalsMapper finalsMapper;

    public List<Finals> getFinalses(){
        return finalsMapper.getFinalses();
    }

    public Finals getFinalsById(String id) {
        return finalsMapper.getFinalsById(id);
    }
}
