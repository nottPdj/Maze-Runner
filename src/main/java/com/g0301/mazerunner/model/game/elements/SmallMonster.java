package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.maze.Maze;

import java.util.Arrays;
import java.util.List;

public class SmallMonster extends Monster{
    private static final List<String> image = Arrays.asList(
            " .....     .....  ",
            " .111.     .111. ",
            " .111.     .111. ",
            " .111.......111. ",
            "..1111111111111..",
            ".111111111111111.",
            ".111..11111..111.",
            ".111..11111..111.",
            ".111.2111112.111.",
            ".111..11111..111.",
            "...11111111111...",
            ".1.1111.1.1111.1.",
            ".1.111.1.1.111.1.",
            "....111...111....",
            "   .111. .111.   ",
            "   ..... .....   "
    );

    private final int speed = 5;
    public SmallMonster(int x, int y) {
        super(x, y);
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public boolean canMove(MazePosition position, Controller<Maze> controller){
        return controller.getModel().isEmpty(position);
    }

    @Override
    public List<String> getImage() {
        return image;
    }
}
