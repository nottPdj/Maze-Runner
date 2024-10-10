package com.g0301.mazerunner.model.menu;

import java.util.Arrays;

public class Lost extends Menu {
    public Lost(){
        super(Arrays.asList("Try Again","Quit"),
                Arrays.asList(
                        "__   __            _     _____ _____ _____ ",
                        "\\ \\ / /           | |   |  _  /  ___|_   _|",
                        " \\ V /___  _   _  | |   | | | \\ `--.  | |  ",
                        "  \\ // _ \\| | | | | |   | | | |`--. \\ | |  ",
                        "  | | (_) | |_| | | |___\\ \\_/ /\\__/ / | |  ",
                        "  \\_/\\___/ \\__,_| \\_____/\\___/\\____/  \\_/  "
                ));
    }

    public boolean isSelectedTryAgain() {
        return isSelected(0);
    }

    public boolean isSelectedQuit() {
        return isSelected(1);
    }
}
