package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.Observable;
import com.g0301.mazerunner.Observer;
import com.g0301.mazerunner.model.game.MazePosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Element implements Observable {
    private static final List<List<String>> image = Arrays.asList(Arrays.asList(
            "                ",
            "      ....      ",
            "     .----.     ",
            "    .------.    ",
            "    .------.    ",
            "    .------.    ",
            "    ........    ",
            "    .z0000z.    ",
            "   .00z00z00.   ",
            "  h.000--000.h  ",
            "  h.000--000.h  ",
            "   .00z00z00.   ",
            "    .z0000z.    ",
            "     .0000.     ",
            "      ....      ",
            "                ",
            "                "
            ),Arrays.asList(
            "                ",
            "                ",
            "     hh         ",
            "    ....        ",
            "   .0000.....   ",
            "  .z0000z.---.  ",
            " .00z00z0.----. ",
            " .000--00.----. ",
            " .000--00.----. ",
            " .00z00z0.----. ",
            "  .z0000z.---.  ",
            "   .0000.....   ",
            "    ....        ",
            "     hh         ",
            "                ",
            "                "
    ),Arrays.asList(
            "                ",
            "                ",
            "      ....      ",
            "     .0000.     ",
            "    .z0000z.    ",
            "   .00z00z00.   ",
            "  h.000--000.h  ",
            "  h.000--000.h  ",
            "   .00z00z00.   ",
            "    .z0000z.    ",
            "    ........    ",
            "    .------.    ",
            "    .------.    ",
            "    .------.    ",
            "     .----.     ",
            "      ....      ",
            "                ",
            "                "
    ),Arrays.asList(
            "                ",
            "                ",
            "         hh     ",
            "        ....    ",
            "   .....0000.   ",
            "  .---.z0000z.  ",
            " .----.0z00z00. ",
            " .----.00--000. ",
            " .----.00--000. ",
            " .----.0z00z00. ",
            "  .---.z0000z.  ",
            "   .....0000.   ",
            "        ....    ",
            "         hh     ",
            "                ",
            "                "
    ));

    private List<Observer> observers;
    boolean dead = false;
    private int index;


    public Player(int x, int y) {
        super(x, y);
        observers = new ArrayList<>();
    }
    public boolean isdead(){
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public void indexImage(int index){
        this.index=index;
    }

    @Override
    public void setPosition(MazePosition position) {
        super.setPosition(position);
        notifyObservers();
    }

    @Override
    public List<String> getImage() {
        return image.get(index);
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
