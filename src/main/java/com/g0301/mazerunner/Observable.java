package com.g0301.mazerunner;

import com.g0301.mazerunner.model.game.MazePosition;

public interface Observable {

    public void add(Observer observer);

    public void remove(Observer observer);

    public void notifyObservers();

}
