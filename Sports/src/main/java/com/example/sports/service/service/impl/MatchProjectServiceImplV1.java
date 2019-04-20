package com.example.sports.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.sports.bean.MatchProject;
import com.example.sports.bean.UpdateMatchProject;
import com.example.sports.controller.viewobject.MatchProjectViw;
import com.example.sports.dao.MatchProjectDao;
import com.example.sports.dao.MatchProjectInterface;
import com.example.sports.service.service.MatchProjectServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 比赛项目相关操作接口
 * @author Misaki
 *
 */
@Service
public class MatchProjectServiceImplV1 implements MatchProjectServiceV1 {
    @Autowired
    MatchProjectInterface matchProjectInterface;
    /**
     * 插入比赛项目
     * @param name 项目名称
     * @param type 项目类型
     * @param time 时间
     */
    public void insertMatchProject(String name, int type, String time) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        if(time == null || "".equals(time.trim())) {
            return;
        }
        MatchProject matchProject = new MatchProject();
        matchProject.setName(name);
        matchProject.setType(type);
        matchProject.setTime(time);
        matchProjectInterface.insertMatchProject(matchProject);
    }
    /**
     * 根据比赛名称删除比赛项目
     * @param name 比赛名称
     */
    public void deleteMatchProjectByName(String name) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        MatchProject matchProject = new MatchProject();
        matchProject.setName(name);
        matchProjectInterface.deleteMatchProjectByName(matchProject);
    }
    /**
     * 根据比赛名称修改比赛
     * @param name 新比赛名称
     * @param type 比赛类型
     * @param time 比赛类型
     * @param oldName 旧的比赛名称
     */
    public void updateMatchProjectByName(String name, int type, String time, String oldName) {
        if(name == null || "".equals(name.trim())) {
            return;
        }
        if(time == null || "".equals(time.trim())) {
            return;
        }
        if(oldName == null || "".equals(oldName.trim())) {
            return;
        }
        UpdateMatchProject updateMatchProject = new UpdateMatchProject();
        updateMatchProject.setName(name);
        updateMatchProject.setType(type);
        updateMatchProject.setTime(time);
        updateMatchProject.setOldName(oldName);

        matchProjectInterface.updateMatchProjectByName(updateMatchProject);
    }
    /**
     * 查询所有比赛项目
     * @return 比赛项目集合(名称，类型，时间)
     */
    public List<MatchProjectViw> queryMatchProjectList() {
        List<MatchProject> matchProject = matchProjectInterface.queryMatchProjectList();
        List<MatchProjectViw> matchProjectViwList = new ArrayList<MatchProjectViw>();
        for(int i = 0; i < matchProject.size(); i++) {
            MatchProjectViw matchProjectViw = new MatchProjectViw();
            matchProjectViw.setName(matchProject.get(i).getName());
            if(matchProject.get(i).getType() == 0) {
                matchProjectViw.setType("个人赛");
            } else {
                matchProjectViw.setType("团体赛");
            }
            matchProjectViw.setTime(matchProject.get(i).getTime());
            matchProjectViwList.add(matchProjectViw);
        }
        return matchProjectViwList;
    }
    /**
     * 查询所有个人比赛项目
     * @return 比赛项目集合(名称，类型，时间)
     */
    public List<MatchProjectViw> queryIndividualMatchProjectList() {
        List<MatchProject> matchProject = matchProjectInterface.queryMatchProjectList();
        List<MatchProjectViw> matchProjectViwList = new ArrayList<MatchProjectViw>();
        for(int i = 0; i < matchProject.size(); i++) {
            if(matchProject.get(i).getType() == 0) {
                MatchProjectViw matchProjectViw = new MatchProjectViw();
                matchProjectViw.setName(matchProject.get(i).getName());
                matchProjectViw.setType("个人赛");
                matchProjectViw.setTime(matchProject.get(i).getTime());
                matchProjectViwList.add(matchProjectViw);
            }
        }
        return matchProjectViwList;
    }
    /**
     * 查询所有团体比赛项目
     * @return 比赛项目集合(名称，类型，时间)
     */
    public List<MatchProjectViw> queryTeamlMatchProjectList() {
        List<MatchProject> matchProject = matchProjectInterface.queryMatchProjectList();
        List<MatchProjectViw> matchProjectViwList = new ArrayList<MatchProjectViw>();
        for(int i = 0; i < matchProject.size(); i++) {
            if(matchProject.get(i).getType() == 1) {
                MatchProjectViw matchProjectViw = new MatchProjectViw();
                matchProjectViw.setName(matchProject.get(i).getName());
                matchProjectViw.setType("团体赛");
                matchProjectViw.setTime(matchProject.get(i).getTime());
                matchProjectViwList.add(matchProjectViw);
            }
        }
        return matchProjectViwList;
    }
}
