package com.g0301.mazerunner.states;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.game.MazeController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.game.GameViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class GameState extends State<Maze>{
    public GameState(Maze maze) {
        super(maze);
    }

    @Override
    protected Viewer<Maze> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Maze> getController() {
        return new MazeController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(GAME_WIDTH, GAME_HEIGHT, GAME_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create game GUI");
            throw new RuntimeException(e);
        }
    }

}
