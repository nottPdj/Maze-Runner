package com.g0301.mazerunner.view;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.elements.Wall;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.view.game.GameViewer;
import com.g0301.mazerunner.view.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;

public class WallViewerTest {
    private Wall wall;
    private GUI gui;
    private MazeCamera mazeCamera;

    @BeforeEach
    void init() {
        wall = Mockito.mock(Wall.class);
        gui = Mockito.mock(GUI.class);
        mazeCamera = Mockito.mock(MazeCamera.class);
        Mockito.when(wall.getPosition()).thenReturn(new MazePosition(0, 0));
        Mockito.when(wall.getImage()).thenReturn(Arrays.asList("wall"));
        Mockito.when(mazeCamera.contains(any())).thenReturn(true);
        Mockito.when(mazeCamera.getTopLeft()).thenReturn(new MazePosition(0, 0));
        Mockito.when(mazeCamera.getWidth()).thenReturn(DayStrategy.camWidth);
        Mockito.when(mazeCamera.getHeight()).thenReturn(DayStrategy.camHeight);
    }

    @Test
    void draw() {
        WallViewer wallViewer = new WallViewer();
        wallViewer.draw(gui, wall, mazeCamera);

        Mockito.verify(gui, Mockito.times(1)).drawImage(0, 0, GameViewer.charWidth, GameViewer.charHeight, Arrays.asList("wall"));
    }
}
