package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.menu.MainMenuController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainMenuControllerTest {

    private MainMenu menu;
    private Game game;
    private MainMenuController controller;
    private GUI gui;
    private GameState gameState;

    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Game.class);
        menu = Mockito.mock(MainMenu.class);
        gameState = Mockito.mock(GameState.class);
        gui = Mockito.mock(GUI.class);
        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);
    }

    @Test
    public void testStartGameOption() throws Exception {
        controller = new MainMenuController(menu);

        Mockito.when(menu.isSelectedStart()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());

        Mockito.verify(gui).close();
        Mockito.verify(game).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testInstructionsOption() throws Exception {
        controller = new MainMenuController(menu);
        Mockito.when(menu.isSelectedInstructions()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
    }

    @Test
    public void testQuitOption() throws Exception {
        controller = new MainMenuController(menu);
        Mockito.when(menu.isSelectedQuit()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        Mockito.verify(game).setState(null);
    }

}
