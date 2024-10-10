package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.maze.LoaderMazeBuilder;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.states.GameState;
import com.g0301.mazerunner.states.InstructionsState;
import com.g0301.mazerunner.states.MainMenuState;

import java.io.IOException;

import static com.g0301.mazerunner.gui.GUI.ACTION.ESCAPE;
import static com.g0301.mazerunner.gui.GUI.ACTION.SELECT;

public class InstructionsController extends Controller<Instructions> {
    public InstructionsController(Instructions menu){
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action== ESCAPE || action == SELECT) {
            game.getState().getGui().close();
            game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
