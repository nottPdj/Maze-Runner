package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.game.MazeController;
import com.g0301.mazerunner.controller.game.MonsterController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.camera.Camera;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.elements.Wall;
import com.g0301.mazerunner.model.game.maze.Map;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.model.menu.Lost;
import com.g0301.mazerunner.states.*;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.NightStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MazeControllerTest {
    private Game game;
    private MazeController controller;
    private Maze maze;
    private GUI gui;
    private GameState gameState;
    private Player player;
    private Map map;

    @BeforeEach
    public void setUp(){
        player=mock(Player.class);
        gameState=Mockito.mock(GameState.class);
        game= Mockito.mock(Game.class);
        maze=Mockito.mock(Maze.class);
        controller=new MazeController(maze);
        gui=Mockito.mock(GUI.class);
    }

    @Test
    public void switchStat(){
        MazeController controller = new MazeController(maze);
        MazeCamera camera = Mockito.mock(MazeCamera.class);
        List<Ground> grounds = Arrays.asList(Mockito.mock(Ground.class), Mockito.mock(Ground.class));
        List<Wall> walls = Arrays.asList(Mockito.mock(Wall.class), Mockito.mock(Wall.class));
        List<Monster> monsters = Arrays.asList(Mockito.mock(Monster.class), Mockito.mock(Monster.class));
        when(maze.getCamera()).thenReturn(camera);
        when(maze.getMonsters()).thenReturn(monsters);
        when(maze.getGrounds()).thenReturn(grounds);
        when(maze.getWalls()).thenReturn(walls);
        controller.getModel().setCamera(camera);
        controller.getModel().setGrounds(grounds);
        controller.getModel().setWalls(walls);
        controller.getModel().setMonsters(monsters);
        assertEquals(1, controller.getIndex());

        controller.switchStrategy();

        assertEquals(0, controller.getIndex());
        verify(camera).setStrategy(isA(DayStrategy.class));
        for (Ground ground : grounds) {
            verify(ground).setStrategy(isA(DayStrategy.class));
        }
        for (Wall wall : walls) {
            verify(wall).setStrategy(isA(DayStrategy.class));
        }

        for (Monster monster : monsters) {
            verify(monster).setPosition(monster.getSpawnPosition());
        }

    }

    @Test
    public void lostGame() throws IOException {
        when(maze.getPlayer()).thenReturn(player);
        when(player.isdead()).thenReturn(true);
        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);
        controller.step(game,GUI.ACTION.UP,System.currentTimeMillis());
        verify(gui).close();
        verify(game).setState(isA(LostState.class));
    }
    @Test
    public void wonGame() throws IOException {
        when(maze.getPlayer()).thenReturn(player);
        when(player.isdead()).thenReturn(false);
        when(maze.outsideMap()).thenReturn(true);
        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);
        controller.step(game,GUI.ACTION.UP,System.currentTimeMillis());
        verify(gui).close();
        verify(game).setState(isA(WonState.class));
    }
    @Test
    public void testEsc() throws IOException {
        when(maze.getPlayer()).thenReturn(player);
        when(player.isdead()).thenReturn(false);
        when(maze.outsideMap()).thenReturn(false);
        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);
        controller.step(game,GUI.ACTION.ESCAPE,System.currentTimeMillis());
        verify(game).saveGameState(gameState);
        verify(gui).close();
        verify(game).setState(isA(PauseState.class));
    }
    @Test
    public void testMap() throws IOException {
        map=new Map(5,5);
        when(maze.getPlayer()).thenReturn(player);
        when(player.isdead()).thenReturn(false);
        when(maze.outsideMap()).thenReturn(false);
        when(game.getState()).thenReturn(gameState);
        when(gameState.getGui()).thenReturn(gui);
        when(maze.getScoutedMap()).thenReturn(map);
        controller.step(game,GUI.ACTION.MAP,System.currentTimeMillis());
        verify(game).saveGameState(gameState);
        verify(gui).close();
        verify(game).setState(isA(MapState.class));
    }
}
