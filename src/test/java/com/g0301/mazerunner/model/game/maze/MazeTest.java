package com.g0301.mazerunner.model.game.maze;

import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.elements.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {
    private Maze maze;
    private Player player;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Wall> nightWalls;
    private List<Ground> grounds;
    private Map scoutedMap;
    private MazeCamera camera;

    @BeforeEach
    public void setUp() {
        maze = new Maze(10, 8);
        player = new Player(1,1);
        monsters = new ArrayList<>();
        monsters.add(new SmallMonster(2,2));
        walls = new ArrayList<>();
        walls.add(new Wall(3,3));
        nightWalls = new ArrayList<>();
        nightWalls.add(new Wall(4,4));
        grounds = new ArrayList<>();
        grounds.add(new Ground(5,5));
        scoutedMap = new Map(10, 8);
        camera = new MazeCamera(player);
    }

    @Test
    public void setCamera() {
        maze.setCamera(camera);
        assertEquals(camera, maze.getCamera());
    }

    @Test
    public void setPlayer() {
        maze.setPlayer(player);
        assertEquals(player, maze.getPlayer());
    }

    @Test
    public void setGrounds() {
        maze.setGrounds(grounds);
        assertEquals(grounds, maze.getGrounds());
    }

    @Test
    public void setMap() {
        maze.setGrounds(grounds);
        maze.setPlayer(player);
        maze.setMap(scoutedMap);
        assertEquals(scoutedMap, maze.getScoutedMap());
        assertEquals(grounds, scoutedMap.getGrounds());
        assertEquals(player, scoutedMap.getPlayer());
    }

    @Test
    public void setMonsters() {
        maze.setMonsters(monsters);
        assertEquals(monsters, maze.getMonsters());
    }

    @Test
    public void getMonsters() {
        maze.setMonsters(monsters);
        assertEquals(monsters, maze.getMonsters());
    }

    @Test
    public void getWalls() {
        maze.setWalls(walls);
        assertEquals(walls, maze.getWalls());
    }

    @Test
    public void setWalls() {
        maze.setWalls(walls);
        assertEquals(walls, maze.getWalls());
    }

    @Test
    public void getNightWalls() {
        maze.setNightWalls(nightWalls);
        assertEquals(nightWalls, maze.getNightWalls());
    }

    @Test
    public void setNightWalls() {
        maze.setNightWalls(nightWalls);
        assertEquals(nightWalls, maze.getNightWalls());
    }

    @Test
    public void isMonster() {
        MazePosition monsterPosition = new MazePosition(2,2);
        Monster monster = new SmallMonster(2,2);
        monsters.add(monster);
        maze.setMonsters(monsters);
        assertTrue(maze.isMonster(monsterPosition));
    }

    @Test
    public void isEmpty() {
        Wall wall = new Wall(4,5);
        walls.add(wall);
        maze.setWalls(walls);
        assertFalse(maze.isEmpty(wall.getPosition()));
    }

    @Test
    public void outsideMap() {
        player.setPosition(new MazePosition(-1, 0));
        maze.setPlayer(player);
        assertTrue(maze.outsideMap());
    }

    @Test
    public void setNight() {
        maze.setPlayer(player);
        maze.setNightWalls(nightWalls);
        maze.setWalls(walls);
        maze.setNight(false);
        assertFalse(maze.isNight());
    }

    @Test
    public void getWidth() {
        assertEquals(10, maze.getWidth());
    }

    @Test
    public void getHeight() {
        assertEquals(8, maze.getHeight());
    }

    @Test
    public void getPlayer() {
        maze.setPlayer(player);
        assertEquals(player, maze.getPlayer());
    }

    @Test
    public void isNight() {
        maze.setPlayer(player);
        maze.setNightWalls(nightWalls);
        maze.setWalls(walls);
        maze.setNight(true);
        assertTrue(maze.isNight());
    }

}
