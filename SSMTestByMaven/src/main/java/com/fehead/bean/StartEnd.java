package com.fehead.bean;

public class StartEnd {

    private int[] week_start_end_id;
    private int start;
    private int end;

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setWeek_start_end_id(int[] week_start_end_id) {
        this.week_start_end_id = week_start_end_id;
    }

    public int[] getWeek_start_end_id() {
        return week_start_end_id;
    }
}
