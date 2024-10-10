package com.g0301.mazerunner.view.game;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.elements.Element;

import java.util.List;

public interface ElementViewer<T extends Element> {
    void draw(GUI gui, T element, MazeCamera mazeCamera);
}
