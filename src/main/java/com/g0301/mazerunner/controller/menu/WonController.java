package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.maze.LoaderMazeBuilder;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.model.menu.Won;
import com.g0301.mazerunner.states.GameState;
import com.g0301.mazerunner.states.InstructionsState;

import java.io.IOException;

public class WonController extends Controller<Won> {
    public WonController(Won menu){
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                game.getState().getGui().close();
                if (getModel().isSelectedQuit()) game.setState(null);
                break;
            default:
                break;

        }
    }
}
