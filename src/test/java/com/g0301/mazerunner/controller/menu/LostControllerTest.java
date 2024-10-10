package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.menu.LostController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.Lost;
import com.g0301.mazerunner.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.when;

public class LostControllerTest {
    private Lost menu;
    private Game game;
    private GUI gui;
    private LostController controller;
    private GameState gameState;
    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Game.class);
        menu = Mockito.mock(Lost.class);
        controller= new LostController(menu);
        gameState = Mockito.mock(GameState.class);
        gui = Mockito.mock(GUI.class);
        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);
    }
    @Test
    public void testUp() throws IOException {
        controller.step(game,GUI.ACTION.UP,System.currentTimeMillis());
        Mockito.verify(menu).previousOption();
    }
    @Test
    public void testDown() throws IOException {
        controller.step(game,GUI.ACTION.DOWN,System.currentTimeMillis());
        Mockito.verify(menu).nextOption();
    }
    @Test
    public void testTryAgain() throws IOException {
        Mockito.when(menu.isSelectedTryAgain()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        Mockito.verify(gui).close();
        Mockito.verify(game).setState(Mockito.any(GameState.class));
    }
    @Test
    public void testQuit() throws IOException {
        Mockito.when(menu.isSelectedQuit()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        Mockito.verify(gui).close();
        Mockito.verify(game).setState(null);
    }
}
