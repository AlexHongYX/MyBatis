package com.example.sports.pojo;

//赛程表
public class Match {

    private Integer mat_id;
    private String mat_name;   //项目名称
    private String mat_pretime; //开始时间
    private String mat_remtime;
    private String mat_fintime; //结束时间
    private String mat_athortea;
    private Integer mat_status;
    private Integer mat_timestamp;


    @Override
    public String toString() {
        return "Match{" +
                "mat_id=" + mat_id +
                ", mat_name='" + mat_name + '\'' +
                ", mat_pretime='" + mat_pretime + '\'' +
                ", mat_remtime='" + mat_remtime + '\'' +
                ", mat_fintime='" + mat_fintime + '\'' +
                ", mat_athortea='" + mat_athortea + '\'' +
                ", mat_status=" + mat_status +
                ", mat_timestamp=" + mat_timestamp +
                '}';
    }

    public Integer getMat_id() {
        return mat_id;
    }

    public void setMat_id(Integer mat_id) {
        this.mat_id = mat_id;
    }

    public String getMat_name() {
        return mat_name;
    }

    public void setMat_name(String mat_name) {
        this.mat_name = mat_name;
    }

    public String getMat_pretime() {
        return mat_pretime;
    }

    public void setMat_pretime(String mat_pretime) {
        this.mat_pretime = mat_pretime;
    }

    public String getMat_remtime() {
        return mat_remtime;
    }

    public void setMat_remtime(String mat_remtime) {
        this.mat_remtime = mat_remtime;
    }

    public String getMat_fintime() {
        return mat_fintime;
    }

    public void setMat_fintime(String mat_fintime) {
        this.mat_fintime = mat_fintime;
    }

    public String getMat_athortea() {
        return mat_athortea;
    }

    public void setMat_athortea(String mat_athortea) {
        this.mat_athortea = mat_athortea;
    }

    public Integer getMat_status() {
        return mat_status;
    }

    public void setMat_status(Integer mat_status) {
        this.mat_status = mat_status;
    }

    public Integer getMat_timestamp() {
        return mat_timestamp;
    }

    public void setMat_timestamp(Integer mat_timestamp) {
        this.mat_timestamp = mat_timestamp;
    }
}
