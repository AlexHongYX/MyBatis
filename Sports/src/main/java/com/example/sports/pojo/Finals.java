package com.example.sports.pojo;

//赛果表
public class Finals {

    private String fin_id;
    private String fin_name; //项目名称
    private String fin_rank;  //排名(前八名编号)
    private String fin_score; //成绩(时间或距离之流)
    private String fin_newcord; //破纪录
    private Integer fin_timestamp;

    @Override
    public String toString() {
        return "Finals{" +
                "fin_id='" + fin_id + '\'' +
                ", fin_name='" + fin_name + '\'' +
                ", fin_rank='" + fin_rank + '\'' +
                ", fin_score='" + fin_score + '\'' +
                ", fin_newcord='" + fin_newcord + '\'' +
                ", fin_timestamp=" + fin_timestamp +
                '}';
    }

    public String getFin_id() {
        return fin_id;
    }

    public void setFin_id(String fin_id) {
        this.fin_id = fin_id;
    }

    public String getFin_name() {
        return fin_name;
    }

    public void setFin_name(String fin_name) {
        this.fin_name = fin_name;
    }

    public String getFin_rank() {
        return fin_rank;
    }

    public void setFin_rank(String fin_rank) {
        this.fin_rank = fin_rank;
    }

    public String getFin_score() {
        return fin_score;
    }

    public void setFin_score(String fin_score) {
        this.fin_score = fin_score;
    }

    public String getFin_newcord() {
        return fin_newcord;
    }

    public void setFin_newcord(String fin_newcord) {
        this.fin_newcord = fin_newcord;
    }

    public Integer getFin_timestamp() {
        return fin_timestamp;
    }

    public void setFin_timestamp(Integer fin_timestamp) {
        this.fin_timestamp = fin_timestamp;
    }
}
