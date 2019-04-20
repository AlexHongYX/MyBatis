package com.example.sports.util;

import java.util.List;

public class PageCustom<T> extends Page<T>{

    public PageCustom(List<T> data, int pageNo, int totalNo, int totalSize, int startNo, int endNo, int minNum, int maxNum) {
        super(data, pageNo, totalNo, totalSize);
        this.startNo = startNo;
        this.endNo = endNo;
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    public PageCustom(){}

    private int startNo;    //页码栏：开始页码
    private int endNo;      //页码栏：末尾页码
    private int minNum;     //最上记录编号 (不是数据库中的id)
    private int maxNum;     //最下记录编号

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getEndNo() {
        return endNo;
    }

    public void setEndNo(int endNo) {
        this.endNo = endNo;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
}
