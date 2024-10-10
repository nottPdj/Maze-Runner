package com.g0301.mazerunner.model.game.camera;

import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MazeCameraTest {

    private Player mockPlayer;
    private MazeCamera mazeCamera;

    @BeforeEach
    public void setUp() {
        mockPlayer = Mockito.mock(Player.class);
        mazeCamera = new MazeCamera(mockPlayer);
    }

    @Test
    public void getSize() {
        mazeCamera.setSize(5, 7);

        assertEquals(5, mazeCamera.getWidth());
        assertEquals(7, mazeCamera.getHeight());
    }

    @Test
    public void updateCenterWhenMove() {
        MazePosition initialPosition = new MazePosition(3, 3);
        MazePosition nextPosition = new MazePosition(3, 4);

        Mockito.when(mockPlayer.getPosition()).thenReturn(initialPosition);
        mazeCamera.update();
        assertEquals(initialPosition, mazeCamera.getCenter());

        Mockito.when(mockPlayer.getPosition()).thenReturn(nextPosition);
        mazeCamera.update();
        assertEquals(nextPosition, mazeCamera.getCenter());
    }

    @Test
    public void contains() {
        mazeCamera.setSize(7, 7);
        Mockito.when(mockPlayer.getPosition()).thenReturn(new MazePosition(8, 8));
        mazeCamera.update();
        assertTrue(mazeCamera.contains(new MazePosition(8,8)));

        assertFalse(mazeCamera.contains(new MazePosition(15, 5)));
        assertFalse(mazeCamera.contains(new MazePosition(5, 15)));
        assertFalse(mazeCamera.contains(new MazePosition(0, 5)));
        assertFalse(mazeCamera.contains(new MazePosition(5, 0)));
    }
}
