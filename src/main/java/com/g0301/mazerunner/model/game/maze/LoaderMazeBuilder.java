package com.g0301.mazerunner.model.game.maze;

import com.g0301.mazerunner.model.game.elements.*;
import com.g0301.mazerunner.strategy.NightStrategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class LoaderMazeBuilder extends MazeBuilder {
    private final List<String> maze;
    private int width;

    public LoaderMazeBuilder() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("maze.txt").getFile());
        try (BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            maze = readLines(br);
        }
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        width = 0;
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; ) {
            lines.add(line);
            width = Math.max(width, line.length());
        }
        return lines;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return maze.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < maze.size(); y++) {
            String line = maze.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }
    @Override
    protected List<Wall> createNightWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < maze.size(); y++) {
            String line = maze.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'c') {
                    Wall wall = new Wall(x,y);
                    wall.setStrategy(new NightStrategy());
                    walls.add(wall);
                }
        }

        return walls;
    }


    @Override
    protected List<Ground> createGround() {
        List<Ground> grounds =new ArrayList<>();

        for (int y = 0; y < maze.size(); y++) {
            String line = maze.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == ' ' || line.charAt(x) == 'M' ||
                        line.charAt(x) == 'm' || line.charAt(x) == 'c') grounds.add(new Ground(x, y));
        }

        return grounds;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters =new ArrayList<>();

        for (int y = 0; y < maze.size(); y++) {
            String line = maze.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'm') monsters.add(new SmallMonster(x, y));
                else if (line.charAt(x) == 'M') monsters.add(new BigMonster(x, y));
        }

        return monsters;
    }

    @Override
    protected Player createPlayer() {
        return new Player(getWidth()/2, getHeight()/2);
    }

    @Override
    protected Map createMap() {
        return new Map(getWidth(), getHeight());
    }
}
