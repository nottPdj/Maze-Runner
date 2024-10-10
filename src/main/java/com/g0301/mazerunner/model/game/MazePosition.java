package com.g0301.mazerunner.model.game;

import java.util.Objects;

public class MazePosition implements Position {
    private final int x;
    private final int y;

    public MazePosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }
    public MazePosition getLeft(){
        return new MazePosition(x-1,y);
    }
    public MazePosition getRight(){
        return new MazePosition(x+1,y);
    }
    public MazePosition getUp(){
        return new MazePosition(x,y-1);
    }
    public MazePosition getDown() {
        return new MazePosition(x, y + 1);
    }

    public MazePosition getRandomNeighbour() {
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                return getUp();
            case 1:
                return getRight();
            case 2:
                return getDown();
            default:
                return getLeft();
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof MazePosition)) return false;
        MazePosition position = (MazePosition) obj;
        return x == position.getX() && y == position.getY();
    }
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
