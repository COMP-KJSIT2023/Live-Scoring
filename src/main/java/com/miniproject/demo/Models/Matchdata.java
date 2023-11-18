package com.miniproject.demo.Models;

public class Matchdata {
    private String team1;
    private String team2;
    private String time;
    private String date;

    public Matchdata(String team1, String team2, String time, String date){
        this.team1=team1;
        this.team2=team2;
        this.time=time;
        this.date=date;
    }

    //getters
    public String getteam1(){
        return team1;
    }
    public String getteam2(){
        return team2;
    }
    public String gettime(){
        return time;
    }
    public String getdate(){
        return date;
    }

    //setters
    public void setteam1(String team){
        this.team1=team;
    }
    public void setteam2(String team){
        this.team2=team;
    }
    public void settime(String time){
        this.time=time;
    }
    public void setdate(String date){
        this.date=date;
    }
}
