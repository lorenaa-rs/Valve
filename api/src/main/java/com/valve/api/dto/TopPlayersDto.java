package com.valve.api.dto;

import com.valve.api.entities.PlayerGameHours;

public class TopPlayersDto {

    private String playerName;
    private Integer hours;

    public TopPlayersDto() {
    }

    public TopPlayersDto(String playerName, Integer hours) {
        this.playerName = playerName;
        this.hours = hours;
    }

   public TopPlayersDto(PlayerGameHours playerGameHours) {
    this.playerName = playerGameHours.getPlayer().getFirstName();
    this.hours = playerGameHours.getHours();
}
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

}
