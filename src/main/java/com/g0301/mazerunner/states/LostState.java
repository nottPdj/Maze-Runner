package com.g0301.mazerunner.states;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.menu.LostController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.menu.Lost;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.menu.LostViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class LostState extends State<Lost> {
    public LostState(Lost model) {
        super(model);
    }

    @Override
    protected Viewer<Lost> getViewer() {
        return new LostViewer(getModel());
    }

    @Override
    protected Controller<Lost> getController() {
        return new LostController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(MENU_WIDTH, MENU_HEIGHT, MENU_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create lost menu GUI");
            throw new RuntimeException(e);
        }
    }
}
