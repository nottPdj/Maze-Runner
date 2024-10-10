package com.g0301.mazerunner.view;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.strategy.NightStrategy;
import com.g0301.mazerunner.view.game.GameViewer;
import com.g0301.mazerunner.view.game.GroundViewer;
import com.g0301.mazerunner.view.game.MonsterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;

public class MonsterViewerTest {
    private Monster monster;
    private GUI gui;
    private MazeCamera mazeCamera;

    @BeforeEach
    void init() {
        monster = Mockito.mock(Monster.class);
        gui = Mockito.mock(GUI.class);
        mazeCamera = Mockito.mock(MazeCamera.class);
        Mockito.when(monster.getPosition()).thenReturn(new MazePosition(0, 0));
        Mockito.when(monster.getImage()).thenReturn(Arrays.asList("monster"));
        Mockito.when(mazeCamera.contains(any())).thenReturn(true);
        Mockito.when(mazeCamera.getTopLeft()).thenReturn(new MazePosition(0, 0));
        Mockito.when(mazeCamera.getWidth()).thenReturn(NightStrategy.camWidth);
        Mockito.when(mazeCamera.getHeight()).thenReturn(NightStrategy.camHeight);
    }

    @Test
    void drawMonster() {
        MonsterViewer monsterViewer = new MonsterViewer();
        monsterViewer.draw(gui, monster, mazeCamera);

        Mockito.verify(gui, Mockito.times(1)).drawImage(1 * GameViewer.charWidth * GameViewer.charsPerImage, 1 * GameViewer.charHeight * GameViewer.charsPerImage, GameViewer.charWidth, GameViewer.charHeight, Arrays.asList("monster"));
    }

}
