
package com.valve.api.dto;

import com.valve.api.entities.Game;


public class TopGamesDto {
    
    private String gameName;
    private int totalHours;

     public TopGamesDto(Game par, Integer par1) {
    }

    public TopGamesDto(String gameName, int totalHours) {
        this.gameName = gameName;
        this.totalHours = totalHours;
    }
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
