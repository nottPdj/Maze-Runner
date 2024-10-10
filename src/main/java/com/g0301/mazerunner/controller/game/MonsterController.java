package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.Strategy;

import java.io.IOException;

public class MonsterController extends GameController {

    private Strategy strategy = new DayStrategy();
    public MonsterController(Maze model) {
        super(model);
    }

        public void moveMonster(Monster monster, MazePosition position) {
            if (monster.canMove(position, this)) {
                monster.setPosition(position);
                if (getModel().getPlayer().getPosition().equals(position) && getModel().isNight())
                    getModel().getPlayer().setDead(true);
            }
        }
    public Strategy getStrategy(){
        return this.strategy;
    }
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
            strategy.monsterStep(game, action, time, this);
    }
}

