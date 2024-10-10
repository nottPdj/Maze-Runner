package com.g0301.mazerunner.states;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.menu.WonController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.menu.Won;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.menu.WonViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class WonState extends State<Won>{
    public WonState(Won end) {
        super(end);
    }

    @Override
    protected Viewer<Won> getViewer() {
        return new WonViewer(getModel());
    }

    @Override
    protected Controller<Won> getController() {
        return new WonController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(MENU_WIDTH, MENU_HEIGHT, MENU_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create won menu GUI");
            throw new RuntimeException(e);
        }
    }
}
