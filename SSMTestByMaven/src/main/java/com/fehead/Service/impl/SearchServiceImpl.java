package com.fehead.Service.impl;

import com.fehead.Dao.*;
import com.fehead.Service.SearchService;
import com.fehead.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private BuildDao buildDao;

    @Autowired
    private DayTimeDao dayTimeDao;

    @Autowired
    private StartEndDao startEndDao;

    @Autowired
    private ClassroomMessageDao classroomMessageDao;

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private FindClassroomsDao findClassroomsDao;

    public Map<Integer,String> searchClassroomByMessage(String build, String buildnumber, int buildlevel, int week, int day, int time){
        Map<Integer,String> map = new HashMap<Integer, String>();
        return null;
    }

    public String getBuild(String build,String buildnumber){
        Build build1 = new Build();
        build1.setBuild(build);
        build1.setBuildnumber(buildnumber);
        String build_buildnumber_id = buildDao.getBuild(build1);
        return build_buildnumber_id;
    }

    public String getDay(int day,int time){
        DayTime dayTime = new DayTime();
        dayTime.setDay(day);
        dayTime.setTime(time);
        String day_time_id = dayTimeDao.getDay(dayTime);
        return day_time_id;
    }

    public List<String> getWeeks(int week){
        List<String> weeks_id = startEndDao.getWeeks(week);
        return weeks_id;
    }

    public List<String> getLocation(String week_id,String day_time_id,String build_buildnumber_id){
        ClassroomMessage classroomMessage = new ClassroomMessage();
        classroomMessage.setWeek_start_end_id(week_id);
        classroomMessage.setDay_time_id(day_time_id);
        classroomMessage.setBuild_buildnumber_id(build_buildnumber_id);
        List<String> buildlevel_classroom_id = classroomMessageDao.getLocation(classroomMessage);
        return buildlevel_classroom_id;
    }

    public String getClassroom(int buildlevel,String buildlevel_classrooms_id){
        Location location = new Location();
        location.setBuildlevel(buildlevel);
        location.setBuildlevel_classroom(buildlevel_classrooms_id);
        String classroom = locationDao.getClassroom(location);
        return classroom;
    }

    public List<String> queryClassroom(int week,String day_time_id,String build_buildnumber_id,int buildlevel){
        FindClassroomBean findClassroomBean = new FindClassroomBean();
        findClassroomBean.setWeek(week);
        findClassroomBean.setDay_time_id(day_time_id);
        findClassroomBean.setBuild_buildnumber_id(build_buildnumber_id);
        findClassroomBean.setBuildlevel(buildlevel);
        List<String> classrooms = findClassroomsDao.getClassrooms(findClassroomBean);
        return classrooms;
    }
}
