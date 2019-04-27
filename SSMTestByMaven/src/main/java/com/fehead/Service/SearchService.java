package com.fehead.Service;


import java.util.List;
import java.util.Map;

public interface SearchService {

    public Map<Integer,String> searchClassroomByMessage(String build, String buildnumber, int buildlevel, int week, int day, int time);

    public String getBuild(String build,String buildnumber);

    public String getDay(int time,int day);

    public List<String> getWeeks(int week);

    public List<String> getLocation(String week_id,String day_time_id,String build_buildnumber_id);

    public String getClassroom(int buildlevel,String buildlevel_classrooms_id);

    public List<String> queryClassroom(int week,String day_time_id,String build_buildnumber_id,int buildlevel);
}
