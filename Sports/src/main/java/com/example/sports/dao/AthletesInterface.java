package com.example.sports.dao;

import com.example.sports.bean.Athletes;
import com.example.sports.bean.UpdateAthletes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthletesInterface {

    //查找所有运动员
    List<Athletes> queryAthletesList();

    //根据学号查找运动员
    Athletes queryAthleteByStuNum(String stuNum);

    //根据id查找运动员
    Athletes queryAthleteById(int id);

    //根据名称查找团体
    Athletes queryTeamByName(String name);

    //根据比赛项目查找运动员
    List<Athletes> queryAthletesListByMatchProject(String name);

    //添加运动员信息
    void insertAthletes(Athletes athletes);

    //根据学号删除运动员
    void deleteAthletesByStuNum(String stuNum);

    //根据姓名删除运动员（团体）
    void deleteAthletesByName(String name);

    //根据学号修改运动员信息
    void updateAthletesByStuNum(UpdateAthletes updateAthletes);

    //根据名称修改团体信息
    void updateAthletesByName(UpdateAthletes updateAthletes);

    //
}
