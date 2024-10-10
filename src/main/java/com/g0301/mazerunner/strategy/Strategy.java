package com.g0301.mazerunner.strategy;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.game.MonsterController;
import com.g0301.mazerunner.gui.GUI;

import java.util.List;

public interface Strategy {
    public int getCamWidth();
    public int getCamHeight();

    public void monsterStep(Game game, GUI.ACTION action, long time, MonsterController controller);

    public List<String> getWall();
    public List<String> getGround();

}