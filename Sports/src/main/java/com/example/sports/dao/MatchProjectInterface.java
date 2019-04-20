package com.example.sports.dao;

import com.example.sports.bean.MatchProject;
import com.example.sports.bean.UpdateMatchProject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchProjectInterface {

    void insertMatchProject(MatchProject matchProject);

    void deleteMatchProjectByName(MatchProject matchProject);

    void updateMatchProjectByName(UpdateMatchProject updateMatchProject);

    List<MatchProject> queryMatchProjectList();

    MatchProject queryMatchProjectByName(MatchProject matchProject);


}
