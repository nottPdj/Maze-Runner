package com.g0301.mazerunner.model.game.elements;


import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.view.game.MonsterViewer;


import java.util.Arrays;
import java.util.List;

public abstract class Monster extends Element {
    private MazePosition spawnPosition;

    private long lastmove;

    public Monster(int x, int y) {
        super(x, y);
        spawnPosition= new MazePosition(x,y);
        lastmove=0;
    }
    public MazePosition getSpawnPosition(){
        return spawnPosition;
    }

    public abstract int getSpeed();
    public abstract boolean canMove(MazePosition position, Controller<Maze> controller);

    public void setLastmove(long lastmove) {
        this.lastmove = lastmove;
    }
    @Override
    public abstract List<String> getImage();

    public long getLastmove(){return lastmove;}
}
