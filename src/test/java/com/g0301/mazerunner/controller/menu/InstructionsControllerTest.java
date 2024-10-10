package com.g0301.mazerunner.controller.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.menu.InstructionsController;
import com.g0301.mazerunner.controller.menu.MainMenuController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.states.GameState;
import com.g0301.mazerunner.states.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstructionsControllerTest {
    private Instructions menu;
    private Game game;
    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Game.class);
        menu = Mockito.mock(Instructions.class);
    }
    @Test
    public void TestEsc() throws IOException {
        InstructionsController controller = new InstructionsController(menu);
        GameState gameStateMock = Mockito.mock(GameState.class);
        GUI guiMock = Mockito.mock(GUI.class);

        when(game.getState()).thenReturn(gameStateMock);
        when(gameStateMock.getGui()).thenReturn(guiMock);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(guiMock).close();
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
    @Test
    public void TestSelect() throws IOException {
        InstructionsController controller = new InstructionsController(menu);
        GameState gameStateMock = Mockito.mock(GameState.class);
        GUI guiMock = Mockito.mock(GUI.class);

        when(game.getState()).thenReturn(gameStateMock);
        when(gameStateMock.getGui()).thenReturn(guiMock);
        controller.step(game, GUI.ACTION.ESCAPE, System.currentTimeMillis());
        verify(guiMock).close();
        verify(game).setState(Mockito.any(MainMenuState.class));
    }
}
