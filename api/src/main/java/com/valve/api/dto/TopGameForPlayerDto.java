package com.valve.api.dto;

import com.valve.api.entities.Game;

public class TopGameForPlayerDto {

    public TopGameForPlayerDto(Game par, Integer par1) {
    }

    public TopGameForPlayerDto(String gameName, int totalHours) {
        this.gameName = gameName;
        this.totalHours = totalHours;
    }
   
    private String gameName;
    private int totalHours;
    
    // Constructor, getters y setters

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }
}
