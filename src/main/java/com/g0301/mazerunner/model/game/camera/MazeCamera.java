package com.g0301.mazerunner.model.game.camera;

import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.Position;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.Observer;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.NightStrategy;
import com.g0301.mazerunner.strategy.Strategy;

public class MazeCamera implements Camera<MazePosition>, Observer {
    private Strategy strategy = new DayStrategy();
    private final Player player;
    private Position center;
    private int width;
    private int height;

    public MazeCamera(Player player) {
        this.player = player;
        setCenter(player.getPosition());
        setSize(strategy.getCamWidth(), strategy.getCamHeight());
    }
    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setCenter(MazePosition center) {
        this.center = center;
    }
    public Position getCenter() {
        return center;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    @Override
    public MazePosition getTopLeft() {
        return new MazePosition(center.getX() - width / 2, center.getY() - height / 2);
    }
    @Override
    public int getRightBoundX() {
        return center.getX() + width / 2;
    }
    @Override
    public int getLeftBoundX() {
        return center.getX() - width / 2;
    }
    @Override
    public int getUpperBoundY() {
        return center.getY() - height / 2;
    }
    @Override
    public int getLowerBoundY() {
        return center.getY() + height / 2;
    }

    public boolean contains(MazePosition position) {
        return !(position.getX() > getRightBoundX() || position.getX() < getLeftBoundX() ||
                position.getY() > getLowerBoundY() || position.getY() < getUpperBoundY());
    }

    @Override
    public void update() {
        setCenter(player.getPosition());
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
        setSize(strategy.getCamWidth(), strategy.getCamHeight());
    }
}