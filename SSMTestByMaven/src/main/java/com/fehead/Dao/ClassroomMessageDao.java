package com.fehead.Dao;


import com.fehead.bean.ClassroomMessage;

import java.util.List;

public interface ClassroomMessageDao {

    public List<String> getLocation(ClassroomMessage classroomMessage);
}
