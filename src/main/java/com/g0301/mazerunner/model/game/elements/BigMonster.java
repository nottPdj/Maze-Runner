package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.maze.Maze;

import java.util.Arrays;
import java.util.List;

public class BigMonster extends Monster {
    private static final List<String> image = Arrays.asList(
            "                ",
            "   +        +   ",
            "  +*+ ++++ +*+  ",
            "  +,*+4444+*,+  ",
            " +,+,459954,+,+ ",
            " +*+459__954+*+ ",
            "+*3+459__954+3*+",
            " +++45699654+++ ",
            " +*,45566554,*+ ",
            " +,+,544445,+,+ ",
            "+*3++479974++3*+",
            " ++,*489984*,++ ",
            "  +*++4664++*+  ",
            " +,3+ ++++ +3,+ ",
            "  ++        ++  ",
            "                "
    );
    private int speed = 5;
    public BigMonster(int x, int y) {
        super(x, y);
    }
    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean canMove(MazePosition position, Controller<Maze> controller) {
        int mazeWidth = controller.getModel().getWidth();
        int mazeHeight = controller.getModel().getHeight();
        return (position.getX() > 0) &&
                (position.getX() < mazeWidth) &&
                (position.getY() > 0) &&
                (position.getY() < mazeHeight);
    }

    @Override
    public List<String> getImage() {
        return image;
    }
}
