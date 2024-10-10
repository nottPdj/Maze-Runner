package com.g0301.mazerunner.model.game.maze;

import com.g0301.mazerunner.Observable;
import com.g0301.mazerunner.Observer;
import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private List<Ground> grounds;
    private Player player;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Ground> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<Ground> grounds) {
        this.grounds = grounds;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
