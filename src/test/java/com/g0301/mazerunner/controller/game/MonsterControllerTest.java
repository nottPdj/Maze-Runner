package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.controller.game.MonsterController;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.elements.Monster;
import com.g0301.mazerunner.model.game.elements.Player;
import com.g0301.mazerunner.model.game.maze.Maze;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.strategy.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    private MonsterController controller;
    private Monster monster;
    private Maze maze;
    private MazePosition position;
    private Player player;
    @BeforeEach
    public void setUp(){
        player=new Player(10,10);
        maze=Mockito.mock(Maze.class);
        monster= Mockito.mock(Monster.class);
        controller =new MonsterController(maze);
    }
    @Test
    public void moveMonster(){
        position=new MazePosition(5,5);
        when(monster.canMove(position, controller)).thenReturn(true);
        when(maze.getPlayer()).thenReturn(player);
        controller.moveMonster(monster, position);

        verify(monster, times(1)).setPosition(position);
    }
    @Test
    public void setStrat(){
        Strategy newStrategy = new DayStrategy();
        controller.setStrategy(newStrategy);
        assertEquals(newStrategy,controller.getStrategy()   );
    }

}
