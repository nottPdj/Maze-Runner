package com.g0301.mazerunner.model.menu;

import java.util.Arrays;

public class Won extends Menu {

    public Won(){
        super(Arrays.asList("Quit"),
                Arrays.asList(
                        "__   __            _____ _____ _____   ___  ______ ___________ ",
                        "\\ \\ / /           |  ___/  ___/  __ \\ / _ \\ | ___ \\  ___|  _  \\",
                        " \\ V /___  _   _  | |__ \\ `--.| /  \\// /_\\ \\| |_/ / |__ | | | |",
                        "  \\ // _ \\| | | | |  __| `--. \\ |    |  _  ||  __/|  __|| | | |",
                        "  | | (_) | |_| | | |___/\\__/ / \\__/\\| | | || |   | |___| |/ / ",
                        "  \\_/\\___/ \\__,_| \\____/\\____/ \\____/\\_| |_/\\_|   \\____/|___/  "
                ));
    }
    public boolean isSelectedQuit() {
        return isSelected(0);
    }


}
