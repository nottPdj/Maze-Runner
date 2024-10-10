package com.g0301.mazerunner.strategy;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.controller.game.MonsterController;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.model.game.maze.Maze;

import java.util.Arrays;
import java.util.List;

public class NightStrategy implements Strategy{

    public static final int  camWidth = 5;
    public static final int  camHeight = 5;

    @Override
    public int getCamWidth() {
        return camWidth;
    }

    @Override
    public int getCamHeight() {
        return camHeight;
    }

    @Override
    public void monsterStep(Game game, GUI.ACTION action, long time, MonsterController controller) {
        for (Monster monster : controller.getModel().getMonsters()) {
            int monsterSpeed = monster.getSpeed();
            if ( time - monster.getLastmove() > 1000/monsterSpeed) {
                controller.moveMonster(monster, monster.getPosition().getRandomNeighbour());
                monster.setLastmove(time);
            }
        }
    }

    @Override
    public List<String> getWall() {
        return Arrays.asList(
                "ABBBBBBBBBBBAAAC",
                "BDADAAAAADDDDDAC",
                "BADADDDDDDAAEDDC",
                "BDEDAADEDADEDEEC",
                "BEFEEDADDEEDEFDC",
                "AEFDDEEEEDAEFDEC",
                "FFFFFFFFFFFFFFFC",
                "GGCCGGCCCGGGGGGG",
                "BBBBBBACABBBBBBB",
                "EAAAADDCBADAAAAD",
                "ADDADDECBDEAEADD",
                "DAADDEFCBEDEDDDA",
                "DDDDEDECAEEDADEE",
                "EEFEFFECADDEEDDE",
                "FFFFFFFCFFFFFFFF",
                "GGGGGGCCCCGGGGGG");
    }

    @Override
    public List<String> getGround() {
        return Arrays.asList(
                "RSTRRSURRVURRUUW",
                "STVSUVWRTUVRSRVV",
                "TRSVTRRVURUSURTW",
                "TUUTWSVVUURUSSVR",
                "RTUWRVWRVRRSWVVU",
                "UVUTVVVRRSVTRVRV",
                "SURRUVRTVVRWVTUR",
                "TSRUTRSVRVWSVWRW",
                "RURURUVSVVVRVVWV",
                "RRSWUVRVRWSURURV",
                "USWVRRSVVRVVTRWV",
                "UURTVVVRWRVRRVUR",
                "VUUSVRWSRVRUSVRV",
                "USUWRVSVRRSVRWSV",
                "RVUTSVUUVUWSVSVV",
                "VRRRWVVUUWVVURVS");
    }


}
