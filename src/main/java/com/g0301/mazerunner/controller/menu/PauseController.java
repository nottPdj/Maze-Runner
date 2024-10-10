package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.model.menu.Pause;
import com.g0301.mazerunner.states.InstructionsState;

import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController (Pause menu){
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
                if (getModel().isSelectedQuit()) game.setState(null);
                if (getModel().isSelectedResume()) game.loadGameState();
                break;
            case ESCAPE:
                game.getState().getGui().close();
                game.loadGameState();
                break;
            default:
                break;
        }
    }
}
