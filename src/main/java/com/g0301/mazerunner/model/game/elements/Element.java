package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.model.game.MazePosition;

import java.util.List;

public abstract class Element {
    private MazePosition position;

    public Element(int x,int y){
        this.position= new MazePosition(x,y);
    }
    public MazePosition getPosition(){
        return position;
    }
    public void setPosition(MazePosition position){
        this.position=position;
    }
    public abstract List<String> getImage();
}
