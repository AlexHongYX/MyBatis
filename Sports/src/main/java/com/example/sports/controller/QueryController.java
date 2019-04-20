package com.example.sports.controller;

import com.example.sports.mapper.CollegeMapper;
import com.example.sports.pojo.Athletes;
import com.example.sports.pojo.College;
import com.example.sports.pojo.Finals;
import com.example.sports.service.AthletesService;
import com.example.sports.service.FinalsService;
import com.example.sports.util.AjaxResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;


@RequestMapping("query")
@Controller
public class QueryController {

    @Autowired
    private AthletesService athletesService;

    @RequestMapping("index")
    public String query(){
        return "query";
    }



    //查询个人(按姓名查询的sql语句有误,自行检查)
    @ResponseBody
    @RequestMapping("/queryAthletes")
    public Object queryAthletes(@RequestParam(required = false,defaultValue = "",name = "queryText") String queryText,
                                @RequestParam(required = false,defaultValue = "",name = "service") String service){
        AjaxResult result=new AjaxResult();
        try{
            List<Athletes> athletes=null;
            if(service.equals("queryAthletes")){
                athletes= athletesService.queryData();
            }else if(service.equals("queryAthletesByName")){
                athletes=athletesService.queryDataByName(queryText);
            }else if(service.equals("queryAthletesById")){
                athletes=athletesService.queryDataById(queryText);
                System.out.println(athletes);
            }else{
                result.setSuccess(false);
                return result;
            }

            if(athletes==null||athletes.size()==0){
                result.setSuccess(false);
                return result;
            }
            result.setData(athletes);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }finally {
            return result;
        }
    }


    //查询项目(未处理个人项与团队项)
    @Autowired
    private FinalsService finalsService;
    @ResponseBody
    @RequestMapping("/getFinalses")
    public Object getFinalses(){
        AjaxResult result=new AjaxResult();
        try{
            List<Finals> finalses = finalsService.getFinalses();
            result.setData(finalses);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }finally {
            return result;
        }


    }

    //根据项目查询个人
    @ResponseBody
    @RequestMapping("/getAthletesByFinalsId")
    public Object getAthletesByFinalsId(@RequestParam(required = false) String id){
        AjaxResult result=new AjaxResult();
        try{
            Finals finals = finalsService.getFinalsById(id);
            String str=finals.getFin_rank();
            String [] arr=str.split(",");
            System.out.println(Arrays.toString(arr));
            List<Athletes> athletes=athletesService.queryDataByIn(arr);
            System.out.println(athletes);
            result.setData(athletes);
            result.setSuccess(true);

        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }finally {
            return result;
        }
    }



    @Autowired
    private CollegeMapper collegeMapper;

    //查询学院
    @ResponseBody
    @RequestMapping("/getColleges")
    public Object getColleges(){
        AjaxResult result=new AjaxResult();
        try {
            List<College> colleges=collegeMapper.getColleges();
            result.setData(colleges);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }finally {
            return result;
        }

    }


    //根据学院查询个人
    @ResponseBody
    @RequestMapping("/getAthletesByCollegeId")
    public Object getAthletesByCollegeId(@RequestParam(required = false) String id){
        AjaxResult result=new AjaxResult();
        try {
            List<Athletes> athletes = athletesService.queryDataByCollegeId(id);
            result.setData(athletes);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }finally {
            return result;
        }
    }




}
