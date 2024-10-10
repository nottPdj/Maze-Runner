package com.g0301.mazerunner.states;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.menu.MainMenuController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.view.Viewer;
import com.g0301.mazerunner.view.menu.MainMenuViewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu menu) {
        super(menu);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }

    @Override
    protected GUI createGui() {
        try {
            return new LanternaGUI(MENU_WIDTH, MENU_HEIGHT, MENU_FONT_SIZE);
        } catch (IOException e) {
            System.out.println("Unable to create main menu GUI");
            throw new RuntimeException(e);
        }
    }

}
