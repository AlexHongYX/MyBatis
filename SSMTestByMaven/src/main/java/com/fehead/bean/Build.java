package com.fehead.bean;

public class Build {

    private int build_buildnumber_id;
    private String build;
    private String buildnumber;

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getBuildnumber() {
        return buildnumber;
    }

    public void setBuildnumber(String buildnumber) {
        this.buildnumber = buildnumber;
    }

    public void setBuild_buildnumber_id(int build_buildnumber_id) {
        this.build_buildnumber_id = build_buildnumber_id;
    }

    public int getBuild_buildnumber_id() {
        return build_buildnumber_id;
    }
}
