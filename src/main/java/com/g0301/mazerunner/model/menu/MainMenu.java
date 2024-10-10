package com.g0301.mazerunner.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu() {
        super(Arrays.asList("Start","Instructions","Quit"),
                Arrays.asList(
                        "___  ___               ______",
                        "|  \\/  |               | ___ \\",
                        "| .  . | __ _ _______  | |_/ /   _ _ __  _ __   ___ _ __",
                        "| |\\/| |/ _` |_  / _ \\ |    / | | | '_ \\| '_ \\ / _ \\ '__|",
                        "| |  | | (_| |/ /  __/ | |\\ \\ |_| | | | | | | |  __/ |",
                        "\\_|  |_/\\__,_/___\\___| \\_| \\_\\__,_|_| |_|_| |_|\\___|_|"
                ));
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedInstructions() {
        return isSelected(1);
    }
    public boolean isSelectedQuit() {
        return isSelected(2);
    }
}
