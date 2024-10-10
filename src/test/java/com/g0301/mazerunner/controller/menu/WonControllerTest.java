package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.menu.WonController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.Won;
import com.g0301.mazerunner.states.GameState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WonControllerTest {
    private Won menu;
    private Game game;
    private GUI gui;
    private WonController controller;
    private GameState gameState;

    @Test
    public void Test() throws IOException {
        game = Mockito.mock(Game.class);
        menu = Mockito.mock(Won.class);
        controller= new WonController(menu);
        gameState = Mockito.mock(GameState.class);
        gui = Mockito.mock(GUI.class);

        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);

        Mockito.when(menu.isSelectedQuit()).thenReturn(true);
        controller.step(game,GUI.ACTION.SELECT,System.currentTimeMillis());
        verify(gui).close();
        verify(game).setState(null);
    }

}
