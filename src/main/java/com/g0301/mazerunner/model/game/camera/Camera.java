package com.g0301.mazerunner.model.game.camera;


import com.g0301.mazerunner.model.game.Position;

public interface Camera<T extends Position> {

    public void setSize(int width, int height);

    public void setCenter(T center);

    public T getTopLeft();

    public int getRightBoundX();

    public int getLeftBoundX();

    public int getUpperBoundY();

    public int getLowerBoundY();
}
