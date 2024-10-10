package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.maze.Maze;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BigMonsterTest {

    @Test
    public void getSpeed() {
        BigMonster bigMonster = new BigMonster(3, 5);

        assertEquals(5, bigMonster.getSpeed());
    }

    @Test
    public void canMoveInsideMaze() {
        Controller<Maze> mockController = Mockito.mock(Controller.class);
        Maze mockMaze = Mockito.mock(Maze.class);
        Mockito.when(mockMaze.getWidth()).thenReturn(10);
        Mockito.when(mockMaze.getHeight()).thenReturn(8);
        Mockito.when(mockController.getModel()).thenReturn(mockMaze);

        BigMonster bigMonster = new BigMonster(5, 4);

        assertTrue(bigMonster.canMove(new MazePosition(6, 4), mockController));
        assertTrue(bigMonster.canMove(new MazePosition(4, 6), mockController));
    }

    @Test
    public void cannotMoveOutsideMaze() {
        Controller<Maze> mockController = Mockito.mock(Controller.class);
        Maze mockMaze = Mockito.mock(Maze.class);
        Mockito.when(mockMaze.getWidth()).thenReturn(10);
        Mockito.when(mockMaze.getHeight()).thenReturn(8);
        Mockito.when(mockController.getModel()).thenReturn(mockMaze);

        BigMonster bigMonster = new BigMonster(1, 1);

        assertFalse(bigMonster.canMove(new MazePosition(0, 1), mockController));
        assertFalse(bigMonster.canMove(new MazePosition(1, 0), mockController));
        assertFalse(bigMonster.canMove(new MazePosition(10, 1), mockController));
        assertFalse(bigMonster.canMove(new MazePosition(1, 8), mockController));
    }

    @Test
    public void getImage() {
        BigMonster bigMonster1 = new BigMonster(2, 3);
        BigMonster bigMonster2 = new BigMonster(1, 4);
        assertEquals(bigMonster1.getImage(), bigMonster2.getImage());
    }

}

