package com.fehead.bean;

public class ClassroomMessage {

    private int id;
    private String week_start_end_id;
    private String day_time_id;
    private String build_buildnumber_id;
    private String buildlevel_classroom;

    public void setWeek_start_end_id(String week_start_end_id) {
        this.week_start_end_id = week_start_end_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuild_buildnumber_id() {
        return build_buildnumber_id;
    }

    public void setBuildlevel_classroom(String buildlevel_classroom) {
        this.buildlevel_classroom = buildlevel_classroom;
    }

    public String getBuildlevel_classroom() {
        return buildlevel_classroom;
    }

    public void setDay_time_id(String day_time_id) {
        this.day_time_id = day_time_id;
    }

    public String getDay_time_id() {
        return day_time_id;
    }

    public void setBuild_buildnumber_id(String build_buildnumber_id) {
        this.build_buildnumber_id = build_buildnumber_id;
    }

    public String getWeek_start_end_id() {
        return week_start_end_id;
    }
}
