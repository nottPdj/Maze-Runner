package com.g0301.mazerunner.view;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.camera.TerminalCamera;
import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.view.game.GameViewer;
import com.g0301.mazerunner.view.game.GroundViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;

public class GroundViewerTest {

    private Ground ground;
    private GUI gui;
    private MazeCamera mazeCamera;

    @BeforeEach
    void init() {
        ground = Mockito.mock(Ground.class);
        gui = Mockito.mock(GUI.class);
        mazeCamera = Mockito.mock(MazeCamera.class);
        Mockito.when(ground.getPosition()).thenReturn(new MazePosition(0, 0));
        Mockito.when(ground.getImage()).thenReturn(Arrays.asList("ground"));
        Mockito.when(mazeCamera.contains(any())).thenReturn(true);
        Mockito.when(mazeCamera.getTopLeft()).thenReturn(new MazePosition(0, 0));
        Mockito.when(mazeCamera.getWidth()).thenReturn(DayStrategy.camWidth);
        Mockito.when(mazeCamera.getHeight()).thenReturn(DayStrategy.camHeight);
    }

    @Test
    void draw() {
        GroundViewer groundViewer = new GroundViewer();
        groundViewer.draw(gui, ground, mazeCamera);

        Mockito.verify(gui, Mockito.times(1)).drawImage(0, 0, GameViewer.charWidth, GameViewer.charHeight, Arrays.asList("ground"));
    }
}
