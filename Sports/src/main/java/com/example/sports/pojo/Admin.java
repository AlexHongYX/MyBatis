package com.example.sports.pojo;

//管理员
public class Admin {

    private Integer auto_id;
    private String adm_userId;
    private String adm_password;
    private Integer adm_timestamp; //时间戳


    @Override
    public String toString() {
        return "Admin{" +
                "auto_id=" + auto_id +
                ", adm_userId='" + adm_userId + '\'' +
                ", adm_password='" + adm_password + '\'' +
                ", adm_timestamp=" + adm_timestamp +
                '}';
    }

    public Integer getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(Integer auto_id) {
        this.auto_id = auto_id;
    }

    public String getAdm_userId() {
        return adm_userId;
    }

    public void setAdm_userId(String adm_userId) {
        this.adm_userId = adm_userId;
    }

    public String getAdm_password() {
        return adm_password;
    }

    public void setAdm_password(String adm_password) {
        this.adm_password = adm_password;
    }

    public Integer getAdm_timestamp() {
        return adm_timestamp;
    }

    public void setAdm_timestamp(Integer adm_timestamp) {
        this.adm_timestamp = adm_timestamp;
    }
}
