package com.g0301.mazerunner.model.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Instructions extends Menu  {

    public Instructions() {
         super(Arrays.asList("Exit"),
                Arrays.asList(
                        " _____          _                   _   _                 ",
                        "|_   _|        | |                 | | (_)                ",
                        "  | | _ __  ___| |_ _ __ _   _  ___| |_ _  ___  _ __  ___ ",
                        "  | || '_ \\/ __| __| '__| | | |/ __| __| |/ _ \\| '_ \\/ __|",
                        " _| || | | \\__ \\ |_| |  | |_| | (__| |_| | (_) | | | \\__ \\",
                        " \\___/_| |_|___/\\__|_|   \\__,_|\\___|\\__|_|\\___/|_| |_|___/"
                )
                 );
    }

    public boolean isSelectedExit() {
        return true;
    }


}
