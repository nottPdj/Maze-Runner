package com.g0301.mazerunner.states;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.game.MapController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.game.maze.Map;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.game.MapViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class MapState extends State<Map> {
    public MapState(Map model) {
        super(model);
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new MapViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(getModel().getWidth() * MapViewer.charWidth, getModel().getHeight() * MapViewer.charHeight, MAP_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create map GUI");
            throw new RuntimeException(e);
        }
    }
}
