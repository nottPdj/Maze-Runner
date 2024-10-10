package com.g0301.mazerunner.view.game;

import com.g0301.mazerunner.gui.GUI;
import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.camera.TerminalCamera;
import com.g0301.mazerunner.model.game.elements.Wall;
import com.googlecode.lanterna.TerminalPosition;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WallViewer implements ElementViewer<Wall> {

    @Override
    public void draw(GUI gui, Wall wall, MazeCamera mazeCamera) {
        TerminalCamera terminalCamera = new TerminalCamera(mazeCamera);
        TerminalPosition terminalPosition = terminalCamera.getTerminalPosition(wall.getPosition());
        gui.drawImage(terminalPosition.getColumn(), terminalPosition.getRow(), GameViewer.charWidth, GameViewer.charHeight, wall.getImage());
    }

}
