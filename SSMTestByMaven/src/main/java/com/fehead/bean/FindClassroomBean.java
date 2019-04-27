package com.fehead.bean;

public class FindClassroomBean {

    private int week;
    private String day_time_id;
    private String build_buildnumber_id;
    private int buildlevel;

    public void setBuild_buildnumber_id(String build_buildnumber_id) {
        this.build_buildnumber_id = build_buildnumber_id;
    }

    public String getDay_time_id() {
        return day_time_id;
    }

    public void setDay_time_id(String day_time_id) {
        this.day_time_id = day_time_id;
    }

    public String getBuild_buildnumber_id() {
        return build_buildnumber_id;
    }

    public void setBuildlevel(int buildlevel) {
        this.buildlevel = buildlevel;
    }

    public int getBuildlevel() {
        return buildlevel;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
}
