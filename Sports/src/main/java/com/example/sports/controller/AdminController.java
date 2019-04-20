package com.example.sports.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.sports.controller.viewobject.CollegePoint;
import com.example.sports.error.BusinessException;
import com.example.sports.error.EmBusinessError;
import com.example.sports.response.CommonReturnType;
import com.example.sports.service.service.CollegeServiceV1;
import com.example.sports.service.service.MatchProjectServiceV1;
import com.example.sports.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author lmwis on 2019-04-03 20:20
 */
@Controller
@RequestMapping("/admin")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class AdminController extends BaseController{

    @Autowired
    CollegeServiceV1 collegeServiceV1;

    @Autowired
    MatchProjectServiceV1 matchProjectServiceV1;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType login(@RequestParam String username, @RequestParam String password) throws BusinessException {
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"用户名或密码为不能为空");
        }
        System.out.println(username);
        System.out.println(password);
        return CommonReturnType.create(null);
    }
    @RequestMapping(value = "index")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = "admin")
    public String index(){
        return "admin-index";
    }
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType test(){
//        CollegePoint[] collegePoint =collegeServiceV1.getAllCollegePoint();
        return  CommonReturnType.create(matchProjectServiceV1.queryMatchProjectList());
    }
}
