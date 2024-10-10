package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.NightStrategy;
import com.g0301.mazerunner.strategy.Strategy;

import java.util.List;

public class Wall extends Element {
    private Strategy strategy = new DayStrategy();
    public Wall(int x, int y) {
        super(x, y);
    }
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }

    @Override
    public List<String> getImage() {
        return strategy.getWall();
    }
}
