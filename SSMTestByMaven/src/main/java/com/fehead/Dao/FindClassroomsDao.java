package com.fehead.Dao;


import com.fehead.bean.FindClassroomBean;

import java.util.List;

public interface FindClassroomsDao {
    public List<String> getClassrooms(FindClassroomBean findClassroomBean);
}
