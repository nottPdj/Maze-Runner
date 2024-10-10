package com.g0301.mazerunner.model.game.maze;

import com.g0301.mazerunner.model.game.elements.*;

import java.util.List;

public abstract class MazeBuilder {
    public Maze createMaze() {
        Maze maze = new Maze(getWidth(), getHeight());

        maze.setPlayer(createPlayer());
        maze.setMonsters(createMonsters());
        maze.setWalls(createWalls());
        maze.setNightWalls(createNightWalls());
        maze.setGrounds(createGround());
        maze.setMap(createMap());

        return maze;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Wall> createNightWalls();

    protected abstract List<Ground> createGround();

    protected abstract List<Monster> createMonsters();

    protected abstract Player createPlayer();

    protected abstract Map createMap();
}

