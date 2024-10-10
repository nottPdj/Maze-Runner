package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.maze.Maze;

import java.io.IOException;

public class PlayerController extends GameController{
    public PlayerController (Maze model){
        super(model);
    }

    private void movePlayer(MazePosition position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isMonster(position) && getModel().isNight())
                getModel().getPlayer().setDead(true);
        }
    }
    public void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    public void movePlayerUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    public void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.UP){
            getModel().getPlayer().indexImage(0);
            movePlayerUp();
        };
        if (action == GUI.ACTION.RIGHT){
            getModel().getPlayer().indexImage(1);
            movePlayerRight();
        }
        if (action == GUI.ACTION.DOWN){
            getModel().getPlayer().indexImage(2);
            movePlayerDown();
        }
        if (action == GUI.ACTION.LEFT){
            getModel().getPlayer().indexImage(3);
            movePlayerLeft();
        }
    }
}
