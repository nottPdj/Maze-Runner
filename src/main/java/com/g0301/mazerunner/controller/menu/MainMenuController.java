package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.maze.LoaderMazeBuilder;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.states.GameState;
import com.g0301.mazerunner.states.InstructionsState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {

    public MainMenuController(MainMenu menu){
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
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsState(new Instructions()));
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderMazeBuilder().createMaze()));
                break;
            default:
                break;
        }
    }
}

