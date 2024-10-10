package com.g0301.mazerunner.view.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.view.Viewer;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);
        drawOptions(gui);
    }

    private void drawTitle(GUI gui) {
        int x = Game.MENU_WIDTH / 2 - getModel().getTitleLength() / 2;
        int y = Game.MENU_HEIGHT * 1 / 8;
        for (String line : getModel().getTitle()) {
            gui.drawText(x, y, line, new TextColor.RGB(0, 255, 0));
            y++;
        }
    }

    private void drawOptions(GUI gui) {
        int startY = Game.MENU_HEIGHT * 1 / 2;
        int space = Game.MENU_HEIGHT * 3 / 8 / getModel().getNumberOfOptions();
        for (int i = 0; i < getModel().getNumberOfOptions(); i++) {
            String option = getModel().getOption(i);
            int x = Game.MENU_WIDTH / 2 - option.length() / 2;
            int y = startY + space * i;
            gui.drawText(x, y, option, getModel().getOptionColor(i));
        }
    }
}
