package com.g0301.mazerunner.states;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.controller.Controller;
import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.gui.LanternaGUI;
import com.g0301.mazerunner.view.Viewer;

import java.io.IOException;

import static com.g0301.mazerunner.Game.*;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    private GUI gui;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
        this.gui = createGui();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    protected abstract GUI createGui();

    public void unpause() {
        reloadGui();
    }

    private void reloadGui() { this.gui = createGui(); }

    public GUI getGui() {
        return gui;
    }

    public T getModel() {
        return model;
    }

    public void step(Game game, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }

}
