package com.g0301.mazerunner.view.game;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.maze.Map;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.view.Viewer;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapViewer extends Viewer<Map> {
    public static final int charWidth = 9;
    public static final int charHeight = 9;

    public MapViewer(Map model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawMap(gui);
        drawScoutedGrounds(gui, getModel().getGrounds());
        drawPlayer(gui, getModel().getPlayer());
    }

    private void drawMap(GUI gui) {
        gui.paintScreen(new TextColor.RGB(191,133,71));
    }

    private void drawScoutedGrounds(GUI gui, List<Ground> scoutedGrounds) {

        for (Ground ground : scoutedGrounds) {
            if (ground.isScouted())
                gui.drawImage(ground.getPosition().getX() * charWidth, ground.getPosition().getY() * charHeight,
                        charWidth, charHeight, Arrays.asList("h"));
        }
    }

    public void drawPlayer(GUI gui, Player player) {
        gui.drawImage(player.getPosition().getX() * charHeight, player.getPosition().getY() * charHeight,
                charWidth, charHeight, Arrays.asList("z"));
    }

}
