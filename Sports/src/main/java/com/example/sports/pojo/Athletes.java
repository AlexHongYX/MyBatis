package com.example.sports.pojo;


//个人表
public class Athletes {

    private String ath_id;
    private String ath_name; //参赛者姓名
    private String ath_sex;  //参赛者性别
    private String ath_college; //学院(外键)
    private String ath_match;   //比赛项目(外键)
    private String ath_score;  //成绩
    private String ath_integral; //积分
    private String ath_status;
    private Integer ath_timestamp;
    private String college_name;
    private String match_name;


    @Override
    public String toString() {
        return "Athletes{" +
                "ath_id=" + ath_id +
                ", ath_name='" + ath_name + '\'' +
                ", ath_sex='" + ath_sex + '\'' +
                ", ath_collegeId=" + ath_college +
                ", ath_matchId=" + ath_match +
                ", ath_score='" + ath_score + '\'' +
                ", ath_Integral='" + ath_integral + '\'' +
                ", ath_status='" + ath_status + '\'' +
                ", ath_timestamp=" + ath_timestamp +
                '}';
    }

    public String getAth_id() {
        return ath_id;
    }

    public void setAth_id(String ath_id) {
        this.ath_id = ath_id;
    }

    public String getAth_name() {
        return ath_name;
    }

    public void setAth_name(String ath_name) {
        this.ath_name = ath_name;
    }

    public String getAth_sex() {
        return ath_sex;
    }

    public void setAth_sex(String ath_sex) {
        this.ath_sex = ath_sex;
    }

    public String getAth_college() {
        return ath_college;
    }

    public void setAth_college(String ath_college) {
        this.ath_college = ath_college;
    }

    public String getAth_match() {
        return ath_match;
    }

    public void setAth_match(String ath_match) {
        this.ath_match = ath_match;
    }

    public String getAth_score() {
        return ath_score;
    }

    public void setAth_score(String ath_score) {
        this.ath_score = ath_score;
    }

    public String getAth_integral() {
        return ath_integral;
    }

    public void setAth_integral(String ath_Integral) {
        this.ath_integral = ath_Integral;
    }

    public String getAth_status() {
        return ath_status;
    }

    public void setAth_status(String ath_status) {
        this.ath_status = ath_status;
    }

    public Integer getAth_timestamp() {
        return ath_timestamp;
    }

    public void setAth_timestamp(Integer ath_timestamp) {
        this.ath_timestamp = ath_timestamp;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }
}
