package com.fehead.bean;

public class Location {

    private String buildlevel_classroom;
    private int buildlevel;
    private String classroom;

    public int getBuildlevel() {
        return buildlevel;
    }

    public void setBuildlevel(int buildlevel) {
        this.buildlevel = buildlevel;
    }

    public String getBuildlevel_classroom() {
        return buildlevel_classroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setBuildlevel_classroom(String buildlevel_classroom) {
        this.buildlevel_classroom = buildlevel_classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
