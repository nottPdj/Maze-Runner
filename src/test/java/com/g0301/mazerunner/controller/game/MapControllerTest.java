package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.game.MapController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.maze.Map;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MapControllerTest {
    private Map map;

    private Game game;
    private  GameState gameStateMock;
    private GUI guiMock;
    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Game.class);
        map = Mockito.mock(Map.class);
        gameStateMock= Mockito.mock(GameState.class);
        guiMock = Mockito.mock(GUI.class);
    }

    @Test
    public void testEsc() throws IOException {
        MapController controller = new MapController(map);
        when(game.getState()).thenReturn(gameStateMock);
        when(gameStateMock.getGui()).thenReturn(guiMock);
        controller.step(game, GUI.ACTION.ESCAPE, System.currentTimeMillis());
        verify(guiMock).close();
        verify(game).loadGameState();
    }

    @Test
    public void testM() throws IOException {
        MapController controller = new MapController(map);
        when(game.getState()).thenReturn(gameStateMock);
        when(gameStateMock.getGui()).thenReturn(guiMock);
        controller.step(game, GUI.ACTION.MAP, System.currentTimeMillis());
        verify(guiMock).close();
        verify(game).loadGameState();
    }
}
