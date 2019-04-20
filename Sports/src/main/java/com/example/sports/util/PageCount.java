package com.example.sports.util;

import java.util.List;
import java.util.Map;

public class PageCount<T> {

    private Map<String,Integer> map;
    private PageCustom<T> pageCustom;
    public void count(List<T> list, Integer pageNo, Integer pageSize, Integer totalSize, Integer step){
        int totalNo;
        totalNo=(totalSize-1)/pageSize+1;
        //分页再分页
        int startNo;
        int endNo;
        if(pageNo%step==0){
            endNo=pageNo;
        }else{
            if((pageNo/step+1)*step>totalNo){
                endNo=totalNo;
            }else{
                endNo=(pageNo/step+1)*step;
            }
        }
        if(endNo%step==0){
            startNo=endNo-step+1;
        }else{
            startNo=endNo-(endNo%step)+1;
        }

        //记录排号
        int minNum;
        int maxNum;
        if(pageNo*pageSize<totalSize){
            maxNum=pageNo*pageSize;
        }else{
            maxNum=totalSize;
        }
        if(maxNum%pageSize==0){
            minNum=maxNum-pageSize+1;
        }else{
            minNum=maxNum-(maxNum%pageSize)+1;
        }

        pageCustom=new PageCustom<>(list,pageNo,totalNo,totalSize,startNo,endNo,minNum,maxNum);
    }




    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public PageCustom getPageCustom() {
        return pageCustom;
    }

    public void setPageCustom(PageCustom pageCustom) {
        this.pageCustom = pageCustom;
    }
}
