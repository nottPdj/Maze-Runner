package com.g0301.mazerunner.model;

import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.maze.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {
    private Map map;
    private List<Ground> grounds;
    private Player player;

    @BeforeEach
    public void setUp() {
        map = new Map(10, 12);
        grounds = new ArrayList<>();
        grounds.add(new Ground(1,1));
        grounds.add(new Ground(1,2));
        grounds.add(new Ground(2,1));
        grounds.add(new Ground(2,2));
        player = new Player(1,2);
    }

    @Test
    public void getWidth() {
        assertEquals(10, map.getWidth());
    }

    @Test
    public void getHeight() {
        assertEquals(12, map.getHeight());
    }

    @Test
    public void getGrounds() {
        map.setGrounds(grounds);
        assertEquals(grounds, map.getGrounds());
    }

    @Test
    public void setGrounds() {
        map.setGrounds(grounds);
        assertEquals(grounds, map.getGrounds());
    }

    @Test
    public void getPlayer() {
        map.setPlayer(player);
        assertEquals(player, map.getPlayer());
    }

    @Test
    public void setPlayer() {
        map.setPlayer(player);
        assertEquals(player, map.getPlayer());
    }
}
