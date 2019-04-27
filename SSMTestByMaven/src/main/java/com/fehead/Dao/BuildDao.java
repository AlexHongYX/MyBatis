package com.fehead.Dao;

import com.fehead.bean.Build;

public interface BuildDao {

    //访问Build的build_buildnumber_id，数据库中的int型（id），如果没有查到就当做null
    String getBuild(Build build);
}
