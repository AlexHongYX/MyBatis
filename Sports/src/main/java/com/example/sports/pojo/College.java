package com.example.sports.pojo;

//学院成绩
public class College {

    private String col_id;
    private String col_name;    //学院名
    private float col_integral; //积分
    private Integer col_gold;   //金牌数
    private Integer col_silver; //银牌数
    private Integer col_copper; //铜牌数
    private Integer col_timestamp;


    @Override
    public String toString() {
        return "College{" +
                "col_id='" + col_id + '\'' +
                ", col_name='" + col_name + '\'' +
                ", col_Integral=" + col_integral +
                ", col_gold=" + col_gold +
                ", col_silver=" + col_silver +
                ", col_copper=" + col_copper +
                ", col_timestamp=" + col_timestamp +
                '}';
    }

    public String getCol_id() {
        return col_id;
    }

    public void setCol_id(String col_id) {
        this.col_id = col_id;
    }

    public String getCol_name() {
        return col_name;
    }

    public void setCol_name(String col_name) {
        this.col_name = col_name;
    }

    public float getCol_integral() {
        return col_integral;
    }

    public void setCol_integral(float col_integral) {
        this.col_integral = col_integral;
    }

    public Integer getCol_gold() {
        return col_gold;
    }

    public void setCol_gold(Integer col_gold) {
        this.col_gold = col_gold;
    }

    public Integer getCol_silver() {
        return col_silver;
    }

    public void setCol_silver(Integer col_silver) {
        this.col_silver = col_silver;
    }

    public Integer getCol_copper() {
        return col_copper;
    }

    public void setCol_copper(Integer col_copper) {
        this.col_copper = col_copper;
    }

    public Integer getCol_timestamp() {
        return col_timestamp;
    }

    public void setCol_timestamp(Integer col_timestamp) {
        this.col_timestamp = col_timestamp;
    }
}
