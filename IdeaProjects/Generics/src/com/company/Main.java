package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        FootballPlayer joe= new FootballPlayer("Joe");
//        BaseballPlayer patt = new BaseballPlayer("Patt");
//        SoccerPlayer ian = new SoccerPlayer("Ian");
//
//        Team<FootballPlayer> team = new Team<>("Yeah");
//        team.addPlayer(joe);
//
//        System.out.println(team.numPlayers());
//
//        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team");
//        baseballTeam.addPlayer(patt);
//
//        Team<SoccerPlayer> soccerteam = new Team<>("Soccer Team");
//        soccerteam.addPlayer(ian);
//
//        Team<FootballPlayer> teamOne = new Team<>("TeamOne");
//        Team<FootballPlayer> teamTwo= new Team<>("TeamTwo");
//        Team<FootballPlayer> teamThree = new Team<>("TeamThree");
//
//        teamOne.matchResult(teamTwo, 3, 0);
//        teamOne.matchResult(teamThree, 1 ,1);
//        teamTwo.matchResult(teamThree, 2 , 3);
//
//        System.out.println(teamOne.getName() + " : " + teamOne.ranking());
//        System.out.println(teamTwo.getName() + " : " + teamTwo.ranking());
//        System.out.println(teamThree.getName() + " : " + teamThree.ranking());
//
//        System.out.println(teamOne.compareTo(teamTwo));
//
//        ArrayList<Team> teams= new ArrayList<>();
//        teams.add(teamOne);
//        teams.add(teamTwo);
//        teams.add(teamThree);
//
//        Collections.sort(teams);
//
//        for (Team value : teams) {
//            System.out.println(value.getName());
//        }

        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        Team<FootballPlayer> makako = new Team<>("Makako");
        Team<FootballPlayer> toma = new Team<>("Toma");
        Team<FootballPlayer> loto = new Team<>("Loto");
        Team<FootballPlayer> sota = new Team<>("Sota");
        Team<FootballPlayer> alto = new Team<>("Alto");
        Team<FootballPlayer> hola = new Team<>("Hola");


        footballLeague.add(hola);
        footballLeague.add(sota);
        footballLeague.add(makako);
        footballLeague.add(loto);
        footballLeague.add(alto);
        footballLeague.add(toma);

        hola.matchResult(sota, 5, 1);
        hola.matchResult(makako, 2, 3);
        hola.matchResult(loto,1,2);
        hola.matchResult(alto,3,2);
        hola.matchResult(toma, 1,3);
        sota.matchResult(makako, 2,1);
        sota.matchResult(loto,3,2);
        sota.matchResult(alto,1,3);
        sota.matchResult(toma,4,3);
        makako.matchResult(loto, 1,1);
        makako.matchResult(alto, 3,3);
        makako.matchResult(toma, 4,3);
        loto.matchResult(alto, 2,1);
        loto.matchResult(toma,1,2);
        alto.matchResult(toma, 1,3);

        footballLeague.showLeagueTable();
    }
}
