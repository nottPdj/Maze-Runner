package com.g0301.mazerunner.view;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.view.game.GameViewer;
import com.g0301.mazerunner.view.game.PlayerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;

public class PlayerViewerTest {
    private Player player;
    private GUI gui;
    private MazeCamera mazeCamera;

    @BeforeEach
    void init() {
        player = Mockito.mock(Player.class);
        gui = Mockito.mock(GUI.class);
        mazeCamera = Mockito.mock(MazeCamera.class);
        Mockito.when(player.getPosition()).thenReturn(new MazePosition(0, 0));
        Mockito.when(player.getImage()).thenReturn(Arrays.asList("player"));
        Mockito.when(mazeCamera.contains(any())).thenReturn(true);
        Mockito.when(mazeCamera.getTopLeft()).thenReturn(new MazePosition(0, 0));
        Mockito.when(mazeCamera.getWidth()).thenReturn(DayStrategy.camWidth);
        Mockito.when(mazeCamera.getHeight()).thenReturn(DayStrategy.camHeight);
    }

    @Test
    void draw() {
        PlayerViewer playerViewer = new PlayerViewer();
        playerViewer.draw(gui, player, mazeCamera);

        Mockito.verify(gui, Mockito.times(1)).drawImage(0, 0, GameViewer.charWidth, GameViewer.charHeight, Arrays.asList("player"));
    }
}
