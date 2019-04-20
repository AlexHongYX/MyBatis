package com.example.sports.service.service.impl;

import com.example.sports.bean.Athletes;
import com.example.sports.bean.College;
import com.example.sports.bean.UpdateAthletes;
import com.example.sports.controller.viewobject.AthletesViw;
import com.example.sports.controller.viewobject.AthletesViwForMatchProject;
import com.example.sports.controller.viewobject.TeamViw;
import com.example.sports.dao.AthletesInterface;
import com.example.sports.dao.CollegeDao;
import com.example.sports.dao.CollegeInterface;
import com.example.sports.service.service.AthletesServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * 运动员相关操作外部接口
 * @author Misaki
 *
 */
@Service
@ContextConfiguration("classpath:application")
public class AthletesServiceImplV1 implements AthletesServiceV1 {

    @Autowired
    AthletesInterface athletesInterface;
    @Autowired
    CollegeInterface collegeInterface;
    /**
     * 根据学院查看运动员信息
     * @return 运动员视图表
     */
    public List<AthletesViw> getAthletesByCollege(int college) {
        List<Athletes> athletes = athletesInterface.queryAthletesList();
        List<AthletesViw> athletesViw = new ArrayList<AthletesViw>();
        for(Athletes athlete : athletes) {
            if(athlete.getCollegeId() == college && athlete.getIsTeam() == 0) {
                AthletesViw athleteViw = new AthletesViw();
                athleteViw.setId(athlete.getId());
                athleteViw.setStuNum(athlete.getStuNum());
                athleteViw.setName(athlete.getName());
                athleteViw.setClassName(athlete.getName());
                athleteViw.setSex(athlete.getSex());
                athletesViw.add(athleteViw);
            }
        }
        return athletesViw;
    }
    /**
     * 根据比赛项目查找运动员
     * @param matchName 比赛项目
     * @return 运动员视图表
     */
    public List<AthletesViwForMatchProject> queryAthletesListByMatchProject(String matchName) {
        //拿到对应比赛的所有运动员信息表
        List<Athletes> athletes = athletesInterface.queryAthletesListByMatchProject(matchName);
        List<College> colleges = collegeInterface.queryCollegeList();
        List<AthletesViwForMatchProject> athletesViwForMatchProject = new ArrayList<AthletesViwForMatchProject>();
        //信息录入运动员视图表
        for(Athletes athlete : athletes) {
            AthletesViwForMatchProject athleteViwForMatchProject = new AthletesViwForMatchProject();
            athleteViwForMatchProject.setId(athlete.getId());
            athleteViwForMatchProject.setStuNum(athlete.getStuNum());
            athleteViwForMatchProject.setName(athlete.getName());
            athleteViwForMatchProject.setSex(athlete.getSex());
            athleteViwForMatchProject.setClassName(athlete.getClassName());
            athleteViwForMatchProject.setCollege(colleges.get(athlete.getCollegeId() - 1).getName());
            athletesViwForMatchProject.add(athleteViwForMatchProject);
        }
        return athletesViwForMatchProject;
    }
    /**
     * 根据学院查看团体信息
     * @return
     */
    public List<TeamViw> getTeamByCollege(int college) {
        List<Athletes> athletes = athletesInterface.queryAthletesList();
        List<TeamViw> teamViw = new ArrayList<TeamViw>();
        for(Athletes team : athletes) {
            if(team.getCollegeId() == college && team.getIsTeam() == 1) {
                TeamViw teamViwt = new TeamViw();
                teamViwt.setId(team.getId());
                teamViwt.setName(team.getName());
                teamViwt.setSex(team.getSex());
                teamViw.add(teamViwt);
            }
        }
        return teamViw;
    }
    /**
     * 添加运动员
     * @param stuNum 学号
     * @param name 姓名
     * @param sex 性别
     * @param collegeId 学院编号
     */
    public void insertAthletes(String stuNum, String name, String sex, int collegeId, String className) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        if(sex == null || "".equals(sex.trim())) {
            return;
        }
        if(stuNum == null || "".equals(stuNum.trim())) {
            return;
        }
        if(className == null || "".equals(className.trim())) {
            return;
        }
        Athletes athletes = new Athletes();
        athletes.setStuNum(stuNum);
        athletes.setName(name);
        athletes.setSex(sex);
        athletes.setCollegeId(collegeId);
        athletes.setClassName(className);
        athletes.setIsTeam(0);
        athletesInterface.insertAthletes(athletes);
    }
    /**
     * 添加团体
     * @param name 团体名称
     * @param sex 团体性别
     * @param collegeId 学院编号
     */
    public void insertTeam(String name, String sex, int collegeId) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        if(sex == null || "".equals(sex.trim())) {
            return;
        }
        Athletes athletes = new Athletes();
        athletes.setStuNum("0");
        athletes.setName(name);
        athletes.setSex(sex);
        athletes.setCollegeId(collegeId);
        athletes.setClassName("NULL");
        athletes.setIsTeam(0);
        athletesInterface.insertAthletes(athletes);
    }
    /**
     * 根据学号删除运动员
     * @param stuNum 学号
     */
    public void deleteAthletesByStuNum(String stuNum) {
        if(stuNum == null || "".equals(stuNum.trim())) {
            return;
        }
        athletesInterface.deleteAthletesByStuNum(stuNum);
    }
    /**
     * 根据姓名删除运动员
     * @param stuNum 学号
     */
    public void deleteAthletesByName(String name) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        athletesInterface.deleteAthletesByName(name);
    }
    /**
     * 根据学号修改运动员信息
     * @param newStuNum 新学号
     * @param name 名字
     * @param sex 性别
     * @param collegeId 学院编号
     * @param className 班级名称
     * @param isTeam 团体/个人
     * @param oldStuNum 旧学号
     */
    public void updateAthletesByStuNum(String StuNum, String name, String sex, int collegeId, String className, String oldStu) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        if(sex == null || "".equals(sex.trim())) {
            return;
        }
        if(StuNum == null || "".equals(StuNum.trim())) {
            return;
        }
        if(oldStu == null || "".equals(oldStu.trim())) {
            return;
        }
        if(className == null || "".equals(className.trim())) {
            return;
        }
        UpdateAthletes updateAthletes = new UpdateAthletes();
        updateAthletes.setStuNum(StuNum);
        updateAthletes.setName(name);
        updateAthletes.setSex(sex);
        updateAthletes.setCollegeId(collegeId);
        updateAthletes.setClassName(className);
        updateAthletes.setOldStuNum(oldStu);
        athletesInterface.updateAthletesByStuNum(updateAthletes);
    }
    /**
     * 根据名称修改团体信息
     * @param newStuNum 新学号
     * @param name 名字
     * @param sex 性别
     * @param collegeId 学院编号
     * @param className 班级名称
     * @param isTeam 团体/个人
     * @param oldStuNum 旧学号
     */
    public void updateTeamsByName(String name, String sex, int collegeId, String oldStu) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        if(sex == null || "".equals(sex.trim())) {
            return;
        }
        if(oldStu == null || "".equals(oldStu.trim())) {
            return;
        }
        UpdateAthletes updateAthletes = new UpdateAthletes();
        updateAthletes.setStuNum("0");
        updateAthletes.setName(name);
        updateAthletes.setSex(sex);
        updateAthletes.setCollegeId(collegeId);
        updateAthletes.setClassName("NULL");
        updateAthletes.setOldStuNum(oldStu);
        athletesInterface.updateAthletesByName(updateAthletes);
    }
}
