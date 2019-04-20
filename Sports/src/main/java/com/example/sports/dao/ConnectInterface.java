package com.example.sports.dao;

import com.example.sports.bean.Connect;
import com.example.sports.bean.MatchProject;
import com.example.sports.bean.MedalNum;
import com.example.sports.bean.UpdateConnect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectInterface {

    List<Connect> queryConnectList();

    List<MedalNum> queryGoldNumList();

    List<MedalNum> querySilverNumList();

    List<MedalNum> queryCopperNumList();



    void insertConnect(Connect connect);

    void updateConnect(UpdateConnect updateConnect);

    List<Connect> queryRank(MatchProject matchProject);

}
