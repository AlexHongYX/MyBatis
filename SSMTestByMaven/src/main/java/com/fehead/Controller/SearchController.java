package com.fehead.Controller;

import com.fehead.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    //获取请求参数和@RequestBody都可以用@RequestParam
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String searchClassroomByMessage(@RequestParam("build") String build,@RequestParam("buildnumber") String buildnumber,
                                           @RequestParam("buildlevel") int buildlevel,@RequestParam("week") int week,
                                           @RequestParam("day") int day,@RequestParam("time") int time){
        System.out.println("build:"+build+" buildnumber:"+buildnumber+" buildlevel:"+buildlevel+" week:"+week+" day:"+day
            +" time:"+time);
        String build_buildnumber_id = searchService.getBuild(build,buildnumber);
        System.out.println("build_buildnumber_id:"+build_buildnumber_id);
        String day_time_id = searchService.getDay(day,time);
        System.out.println("day_time_id:"+day_time_id);
//        List<String> weeks_id = searchService.getWeeks(week);
//        System.out.println("weeks_id:");
//        List<String> buildlevel_classrooms_ids = new ArrayList<String>();
//        for(int i=0;i<weeks_id.size();i++){
//            System.out.println(weeks_id.get(i));
//            List<String> buildlevel_classroom_id = searchService.getLocation(weeks_id.get(i),day_time_id,build_buildnumber_id);
//
//            //把集合1的全部元素插入到集合二
//            buildlevel_classrooms_ids.addAll(buildlevel_classroom_id);
//
//        }
//        System.out.println("buildlevel_classroom_id:");
//        List<String> classrooms = new ArrayList<String>();
//        for(int i=0;i<buildlevel_classrooms_ids.size();i++){
//            System.out.println(buildlevel_classrooms_ids.get(i));
//            String classroom = searchService.getClassroom(buildlevel,buildlevel_classrooms_ids.get(i));
//            classrooms.add(classroom);
//        }
//        System.out.println("End Result,classroom:");
//        for(int i=0;i<classrooms.size();i++){
//            if(classrooms.get(i)!=null){
//                System.out.println(buildlevel*10+classrooms.get(i));
//            }
//        }
        List<String> classrooms = searchService.queryClassroom(week,day_time_id,build_buildnumber_id,buildlevel);
        System.out.println("End Result,classroom:");
        for(int i=0;i<classrooms.size();i++){
            if(classrooms.get(i)!=null){
                System.out.println(buildlevel*10+classrooms.get(i));
            }
        }
        return "search";
    }

    @RequestMapping("index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("hello")
    public String getHello(){
        return "hello";
    }

    @RequestMapping("main")
    public String getMain(){
        return "main";
    }
}
