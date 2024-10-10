package com.g0301.mazerunner.states;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.menu.PauseController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.menu.Pause;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.menu.PauseViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class PauseState extends State<Pause> {
    public PauseState(Pause pause) {
        super(pause);
    }

    @Override
    protected Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    protected Controller<Pause> getController() {
        return new PauseController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(MENU_WIDTH, MENU_HEIGHT, MENU_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create pause menu GUI");
            throw new RuntimeException(e);
        }
    }

}
