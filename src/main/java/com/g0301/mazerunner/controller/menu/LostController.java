package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.maze.LoaderMazeBuilder;
import com.g0301.mazerunner.model.menu.Lost;
import com.g0301.mazerunner.model.menu.Won;
import com.g0301.mazerunner.states.GameState;

import java.io.IOException;

public class LostController extends Controller<Lost> {
    public LostController(Lost menu){
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                game.getState().getGui().close();
                if (getModel().isSelectedTryAgain()) game.setState(new GameState(new LoaderMazeBuilder().createMaze()));
                if (getModel().isSelectedQuit()) game.setState(null);
                break;
            default:
                break;
        }
    }
}
