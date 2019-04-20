package com.example.sports.controller;

import com.example.sports.pojo.College;
import com.example.sports.service.CollegeService;
import com.example.sports.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("index")
@Controller
public class IndexController {

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("getColleges")
    public Object getColleges(){
        AjaxResult result=new AjaxResult();
        try {
            List<College> collegeList=collegeService.getCollegesOrder();
            result.setData(collegeList);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
        }finally {
            return result;
        }
    }
    @ResponseBody
    @RequestMapping("getCollegesV1")
    public Object getCollegesV1(){
        AjaxResult result=new AjaxResult();
        try {
            List<College> collegeList=collegeService.getCollegesOrder();
            result.setData(collegeList);
            result.setSuccess(true);
        }catch (Exception e){
            result.setSuccess(false);
        }finally {
            return result;
        }
    }
}
