package com.example.sports.service;

import com.example.sports.mapper.AdminMapper;
import com.example.sports.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public List<Admin> getAdmins() {
        return adminMapper.getAdmins();
    }
}
