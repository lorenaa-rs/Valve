package com.valve.api.dto;

public class PlayerGameHoursDto {

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public PlayerGameHoursDto() {
    }

    public PlayerGameHoursDto(Integer hours, Long playerId, Long gameId) {
        this.hours = hours;
        this.playerId = playerId;
        this.gameId = gameId;
    }
    private Integer hours;
    private Long playerId;
    private Long gameId;

    // getters, setters, constructor
}
