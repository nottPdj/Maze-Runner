package com.g0301.mazerunner.model.game.elements;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.maze.Maze;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class SmallMonsterTest {

    @Test
    public void getSpeed() {
        SmallMonster smallMonster = new SmallMonster(3, 5);

        assertEquals(5, smallMonster.getSpeed());
    }

    @Test
    public void canMoveInsideMaze() {
        Controller<Maze> mockController = Mockito.mock(Controller.class);
        Maze mockMaze = Mockito.mock(Maze.class);
        Mockito.when(mockController.getModel()).thenReturn(mockMaze);

        SmallMonster smallMonster = new SmallMonster(1, 1);
        MazePosition wallPosition = new MazePosition(1, 2);

        Mockito.when(mockMaze.isEmpty(wallPosition)).thenReturn(true); // Corrected line
        assertTrue(smallMonster.canMove(wallPosition, mockController));
    }

    @Test
    public void cannotMoveWhenPositionIsNotEmpty() {
        Controller<Maze> mockController = Mockito.mock(Controller.class);
        Maze mockMaze = Mockito.mock(Maze.class);
        Mockito.when(mockController.getModel()).thenReturn(mockMaze);

        SmallMonster smallMonster = new SmallMonster(1, 1);
        MazePosition wallPosition = new MazePosition(1, 1);

        Mockito.when(mockMaze.isEmpty(wallPosition)).thenReturn(false);
        assertFalse(smallMonster.canMove(wallPosition, mockController));
    }

    @Test
    public void getImage() {
        SmallMonster smallMonster1 = new SmallMonster(2, 3);
        SmallMonster smallMonster2 = new SmallMonster(1, 4);
        assertEquals(smallMonster1.getImage(), smallMonster2.getImage());
    }

}

