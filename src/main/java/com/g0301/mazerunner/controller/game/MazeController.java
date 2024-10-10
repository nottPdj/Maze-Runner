package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.elements.Ground;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.model.game.elements.Wall;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.model.menu.Lost;
import com.g0301.mazerunner.model.menu.Won;
import com.g0301.mazerunner.model.menu.Pause;
import com.g0301.mazerunner.states.LostState;
import com.g0301.mazerunner.states.WonState;
import com.g0301.mazerunner.states.MapState;
import com.g0301.mazerunner.states.PauseState;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.NightStrategy;
import com.g0301.mazerunner.strategy.Strategy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MazeController extends GameController{
    private final PlayerController playerController;
    private final MonsterController monsterController;
    private List<Strategy> strategies = Arrays.asList(new DayStrategy(),new NightStrategy());
    private long lastTime;
    private long realTime = 0;
    private final long dayTime = 25000;
    boolean isTimeFreeze = false;
    private int index=1;

    public MazeController(Maze model) {
        super(model);
        this.playerController=new PlayerController(model);
        this.monsterController=new MonsterController(model);
    }

    public void switchStrategy(){
        index = index==0?1:0;
        getModel().getCamera().setStrategy(strategies.get(index));
        monsterController.setStrategy(strategies.get(index));
        getModel().setNight(index==1);
        for(Ground ground:getModel().getGrounds())
            ground.setStrategy(strategies.get(index));
        for(Wall wall: getModel().getWalls())
            wall.setStrategy(strategies.get(index));
        if(index==0){
            for(Monster monster: getModel().getMonsters())
                monster.setPosition(monster.getSpawnPosition());
        }
    }

    public void updateTime(long time) {
        realTime = (realTime + lastTime) % 25000;
        lastTime = time;
    }
    public int getIndex(){return index;}
    public void setTimeFreeze(boolean isFreeze) {
        isTimeFreeze = isFreeze;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (isTimeFreeze) {
            setTimeFreeze(false);
            lastTime = time - realTime;
        }

        if(getModel().getPlayer().isdead()){
            game.getState().getGui().close();
            game.setState(new LostState(new Lost()));
        }
        else if (getModel().outsideMap()) {
            game.getState().getGui().close();
            game.setState(new WonState(new Won()));
        }
        else if (action== GUI.ACTION.ESCAPE){
            setTimeFreeze(true);
            game.saveGameState(game.getState());
            game.getState().getGui().close();
            game.setState(new PauseState(new Pause()));
        }
        else if (action == GUI.ACTION.MAP) {
            game.saveGameState(game.getState());
            game.getState().getGui().close();
            game.setState(new MapState(getModel().getScoutedMap()));
        }
        else {
            if( time - lastTime >= dayTime){
                switchStrategy();
                updateTime(time);
            }
            playerController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}
