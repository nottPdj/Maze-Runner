package com.g0301.mazerunner.model.menu;

import java.util.Arrays;
import java.util.List;

public class Pause extends Menu {

    public Pause() {
        super(Arrays.asList("Resume","Quit"),
                Arrays.asList(
                        "______    ______",
                        "|    |    |    |",
                        "|    |    |    |",
                        "|    |    |    |",
                        "|    |    |    |",
                        "|    |    |    |",
                        "|    |    |    |",
                        "|____|    |____|"
                ));
    }
    public boolean isSelectedResume() {
        return isSelected(0);
    }
    public boolean isSelectedQuit() {
        return isSelected(1);
    }

}
