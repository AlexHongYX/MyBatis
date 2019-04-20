package com.example.sports.util;

public class AjaxResult {

    private boolean success;
    private Object data;

    public static AjaxResult create(Object data){
        return AjaxResult.create(data,true);
    }
    public static AjaxResult create(Object data,boolean success){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(success);
        ajaxResult.setData(data);
        return ajaxResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
