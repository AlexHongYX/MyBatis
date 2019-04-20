package com.example.sports;

import com.example.sports.pojo.Athletes;
import com.example.sports.pojo.College;
import com.example.sports.pojo.Finals;
import com.example.sports.service.AthletesService;
import com.example.sports.service.CollegeService;
import com.example.sports.service.FinalsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SportsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private CollegeService collegeService;
    @Test
    public void getColleges(){
        List<College> collegeList=collegeService.getColleges();
        for (College college :collegeList){
            System.out.println(college.getCol_name());
        }
    }

    @Autowired
    private FinalsService finalsService;
    @Test
    public void getFinalses(){
        List<Finals> finalses = finalsService.getFinalses();
        System.out.println(finalses);
    }

    @Autowired
    private AthletesService athletesService;

    @Test
    public void getAthletesByIn(){

        String [] arr={"0607","0605","1200","0703","0202","0600","0502","0606"};
        List<Athletes> athletes = athletesService.queryDataByIn(arr);
        System.out.println(athletes);

    }

    @Test
    public void go(){
        List<Athletes> athletes = athletesService.queryDataByName("张");
        System.out.println(athletes);
    }

    @Test
    public void go2(){
        List<Athletes> athletes = athletesService.queryDataById("01");
        System.out.println(athletes);
    }



}
