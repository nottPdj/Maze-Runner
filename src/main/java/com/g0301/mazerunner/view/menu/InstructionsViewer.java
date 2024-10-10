package com.g0301.mazerunner.view.menu;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.menu.Instructions;
import com.g0301.mazerunner.view.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class InstructionsViewer extends Viewer<Instructions> {

    public InstructionsViewer(Instructions model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);
        drawOptions(gui);
        drawInstructions(gui);
    }

    private void drawTitle(GUI gui) {
        int x = Game.MENU_WIDTH / 2 - getModel().getTitleLength() / 2;
        int y = Game.MENU_HEIGHT * 1 / 8;
        for (String line : getModel().getTitle()) {
            gui.drawText(x, y, line, new TextColor.RGB(255, 255, 255));
            y++;
        }
    }

    private void drawOptions(GUI gui) {
        int startY = Game.MENU_HEIGHT -2;
        int space = Game.MENU_HEIGHT * 3 / 8 / getModel().getNumberOfOptions();
        for (int i = 0; i < getModel().getNumberOfOptions(); i++) {
            String option = getModel().getOption(i);
            int x = Game.MENU_WIDTH / 2 - option.length() / 2;
            int y = startY + space * i;
            gui.drawText(x, y, option, getModel().getOptionColor(i));
        }
    }
    private void drawInstructions(GUI gui) {
        int x = 25;
        int y = Game.MENU_HEIGHT /2 -3;
        gui.drawText(x-10, y, "Try to escape this maze scout it during daytime", new TextColor.RGB(255, 255, 255));
        gui.drawText(x-15, ++y, "and survive the monsters during the darkness of the night.", new TextColor.RGB(255, 255, 255));
        gui.drawText(x+=4, y+=4, "In-Game Instructions:", new TextColor.RGB(255, 255, 255));
        gui.drawText(++x, y+=3, "Move      -> ARROWS", new TextColor.RGB(255, 255, 255));
        gui.drawText(x, ++y, "Open map  -> M", new TextColor.RGB(255, 255, 255));
        gui.drawText(x, ++y, "Close map -> M/ESC", new TextColor.RGB(255, 255, 255));
        gui.drawText(x, ++y, "Pause     -> ESC", new TextColor.RGB(255, 255, 255));
    }

}
