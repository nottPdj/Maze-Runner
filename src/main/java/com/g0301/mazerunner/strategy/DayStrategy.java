package com.g0301.mazerunner.strategy;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.game.MonsterController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.model.game.maze.Maze;

import java.util.Arrays;
import java.util.List;

public class DayStrategy implements Strategy{

    public static final int  camWidth = 7;
    public static final int  camHeight = 7;

    @Override
    public int getCamWidth() {
        return camWidth;
    }

    @Override
    public int getCamHeight() {
        return camHeight;
    }

    @Override
    public void monsterStep(Game game, GUI.ACTION action, long time, MonsterController controller) {}

    @Override
    public List<String> getWall() {
        return Arrays.asList(
                "abbbbbbbbbbbaaac",
                "bdadaaaaadddddac",
                "badaddddddaaeddc",
                "bdedaadedadedeec",
                "befeedaddeedefdc",
                "aefddeeeedaefdec",
                "fffffffffffffffc",
                "ggccggcccggggggg",
                "bbbbbbacabbbbbbb",
                "eaaaaddcbadaaaad",
                "addaddecbdeaeadd",
                "daaddefcbededdda",
                "ddddedecaeedadee",
                "eefeffecaddeedde",
                "fffffffcffffffff",
                "ggggggccccgggggg");
    }

    @Override
    public List<String> getGround() {
        return Arrays.asList(
                "rstrrsurrvurruuw",
                "stvsuvwrtuvrsrvv",
                "trsvtrrvurusurtw",
                "tuutwsvvuurussvr",
                "rtuwrvwrvrrswvvu",
                "uvutvvvrrsvtrvrv",
                "surruvrtvvrwvtur",
                "tsrutrsvrvwsvwrw",
                "rururuvsvvvrvvwv",
                "rrswuvrvrwsururv",
                "uswvrrsvvrvvtrwv",
                "uurtvvvrwrvrrvur",
                "vuusvrwsrvrusvrv",
                "usuwrvsvrrsvrwsv",
                "rvutsvuuvuwsvsvv",
                "vrrrwvvuuwvvurvs");
    }

}
