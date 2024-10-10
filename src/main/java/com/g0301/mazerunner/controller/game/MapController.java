package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.maze.LoaderMazeBuilder;
import com.g0301.mazerunner.model.game.maze.Map;
import com.g0301.mazerunner.states.GameState;

import java.io.IOException;


public class MapController extends Controller<Map> {
    public MapController(Map model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.MAP || action == GUI.ACTION.ESCAPE) {
            game.getState().getGui().close();
            game.loadGameState();
        }
    }
}
