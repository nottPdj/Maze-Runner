package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.game.PlayerController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.elements.Wall;
import com.g0301.mazerunner.model.game.maze.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
        private PlayerController controller;
        private Player player;
        private Maze maze;
        private Game game;

        @BeforeEach
        public void setUp() {
            maze = new Maze(10, 10);

            player = new Player(5, 5);
            maze.setPlayer(player);

            maze.setWalls(Arrays.asList());
            maze.setMonsters(Arrays.asList());

            controller = new PlayerController(maze);
            game=Mockito.mock(Game.class);
        }

        @Test
        public void moveHeroRightEmpty() {
            controller.movePlayerRight();
            assertEquals(new MazePosition(6, 5), player.getPosition());
        }

        @Test
        public void moveHeroRightNotEmpty() {
            maze.setWalls(Arrays.asList(new Wall(6, 5)));
            controller.movePlayerRight();
            assertEquals(new MazePosition(5, 5), player.getPosition());
        }

        @Test
         public void moveHeroUpEmpty() {
             controller.movePlayerUp();
             assertEquals(new MazePosition(5, 4), player.getPosition());
         }

         @Test
         public void moveHeroUptNotEmpty() {
             maze.setWalls(Arrays.asList(new Wall(5, 4)));
             controller.movePlayerUp();
             assertEquals(new MazePosition(5, 5), player.getPosition());
         }
         @Test
         public void moveHeroLeftEmpty() {
             controller.movePlayerLeft();
             assertEquals(new MazePosition(4, 5), player.getPosition());
         }

         @Test
         public void moveHeroLeftNotEmpty() {
             maze.setWalls(Arrays.asList(new Wall(4, 5)));
             controller.movePlayerLeft();
             assertEquals(new MazePosition(5, 5), player.getPosition());
         }
         @Test
         public void moveHeroDownEmpty() {
             controller.movePlayerDown();
             assertEquals(new MazePosition(5,6), player.getPosition());
         }

         @Test
         public void moveHeroDownNotEmpty() {
             maze.setWalls(Arrays.asList(new Wall(5, 6)));
             controller.movePlayerDown();
             assertEquals(new MazePosition(5, 5), player.getPosition());
         }
         @Test
        public void testStep() throws IOException {
            assertEquals(new MazePosition(5, 5), player.getPosition());
            controller.step(game,GUI.ACTION.UP,System.currentTimeMillis());
            assertEquals(new MazePosition(5, 4), player.getPosition());
            controller.step(game,GUI.ACTION.RIGHT,System.currentTimeMillis());
            assertEquals(new MazePosition(6, 4), player.getPosition());
            controller.step(game,GUI.ACTION.DOWN,System.currentTimeMillis());
            assertEquals(new MazePosition(6, 5), player.getPosition());
            controller.step(game,GUI.ACTION.LEFT,System.currentTimeMillis());
            assertEquals(new MazePosition(5, 5), player.getPosition());
    }
}
