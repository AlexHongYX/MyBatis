package com.example.sports.util;

import java.util.List;

public class Page<T> {

    private List<T> data;
    private int pageNo; //当前页码
    private int totalNo;    //总页码
    private int totalSize;  //总记录


    public Page(List<T> data, int pageNo, int totalNo, int totalSize) {
        this.data = data;
        this.pageNo = pageNo;
        this.totalNo = totalNo;
        this.totalSize = totalSize;
    }

    public Page(){}

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalNo() {
        return totalNo;
    }

    public void setTotalNo(int totalNo) {
        this.totalNo = totalNo;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
