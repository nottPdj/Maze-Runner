package com.g0301.mazerunner.states;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.menu.InstructionsController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.menu.InstructionsViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class InstructionsState extends State<Instructions> {
    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(MENU_WIDTH, MENU_HEIGHT, MENU_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create instructions menu GUI");
            throw new RuntimeException(e);
        }
    }
}
