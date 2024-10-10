package com.g0301.mazerunner.view.game;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.model.game.elements.Element;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.view.Viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameViewer extends Viewer<Maze> {
    public final static int charWidth = 3;
    public final static int charHeight = 3;
    public final static int charsPerImage = 16;

    public GameViewer(Maze maze) {
        super(maze);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getGrounds(), new GroundViewer(), getModel().getCamera());
        drawElements(gui, getModel().getWalls(), new WallViewer(), getModel().getCamera());
        if(getModel().isNight()) {
            drawElements(gui, getModel().getMonsters(), new MonsterViewer(), getModel().getCamera());
        }
        drawElement(gui, getModel().getPlayer(), new PlayerViewer(), getModel().getCamera());
    }


    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer, MazeCamera mazeCamera) {
        for (T element : elements) {
            drawElement(gui, element, viewer, mazeCamera);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer, MazeCamera mazeCamera) {
        if (mazeCamera.contains(element.getPosition()))
            viewer.draw(gui, element, mazeCamera);
    }

}
