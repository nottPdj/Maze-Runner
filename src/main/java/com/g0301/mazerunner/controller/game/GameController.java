package com.g0301.mazerunner.controller.game;

import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.model.game.maze.Maze;

public abstract class  GameController extends Controller<Maze> {
    public GameController(Maze model) {
        super(model);
    }
}
