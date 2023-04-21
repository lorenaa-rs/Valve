package com.valve.api.entities;

import javax.persistence.*;

@Entity
public class PlayerGameHours {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private Integer hours;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "player_id", nullable = false)
private Player player;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "game_id", nullable = false)
private Game game;

    public PlayerGameHours() {
    }

    public PlayerGameHours(Long id, Integer hours, Player player, Game game) {
        this.id = id;
        this.hours = hours;
        this.player = player;
        this.game = game;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
