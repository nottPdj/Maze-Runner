package com.g0301.mazerunner.model.game.elements;


import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.NightStrategy;
import com.g0301.mazerunner.strategy.Strategy;

import java.util.Arrays;
import java.util.List;

public class Ground extends Element {
    Strategy strategy = new DayStrategy();
    private boolean scouted = false;

    public Ground(int x, int y) {
        super(x, y);
    }
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }

    @Override
    public List<String> getImage() {
        return strategy.getGround();
    }

    public boolean isScouted() {
        return scouted;
    }

    public void setScouted() {
        scouted = true;
    }
}
