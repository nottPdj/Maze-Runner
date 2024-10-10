package com.g0301.mazerunner.model.game.camera;

import com.g0301.mazerunner.Game;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.TerminalPositionAdapter;
import com.googlecode.lanterna.TerminalPosition;

import static com.g0301.mazerunner.view.game.GameViewer.*;

public class TerminalCamera implements Camera<TerminalPositionAdapter> {
    private MazeCamera mazeCamera;
    private TerminalPositionAdapter center;
    private int width;
    private int height;

    public TerminalCamera(MazeCamera mazeCamera) {
        this.mazeCamera = mazeCamera;
        setCenter(new TerminalPositionAdapter(Game.GAME_WIDTH / 2, Game.GAME_HEIGHT / 2));
        setSize(Game.GAME_WIDTH,  Game.GAME_HEIGHT);
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setCenter(TerminalPositionAdapter center) {
        this.center = center;
    }

    @Override
    public TerminalPositionAdapter getTopLeft() {
        return new TerminalPositionAdapter(center.getX() - (mazeCamera.getWidth() * charWidth * charsPerImage) / 2,
                center.getY() - (mazeCamera.getHeight() * charHeight * charsPerImage) / 2);
    }

    @Override
    public int getRightBoundX() {
        return center.getX() + width / 2;
    }

    @Override
    public int getLeftBoundX() {
        return center.getX() - width / 2;
    }

    @Override
    public int getUpperBoundY() {
        return center.getY() - height / 2;
    }

    @Override
    public int getLowerBoundY() {
        return center.getY() + height / 2;
    }

    public TerminalPosition getTerminalPosition(MazePosition mazePosition) {
        if (!mazeCamera.contains(mazePosition)) {
            System.out.println("Maze Position (" + mazePosition.getX() + ", " + mazePosition.getY() +
                    ") is not contained within the Maze Camera");
        }
        int mazePosRelativeToMazeCamX = mazePosition.getX() - mazeCamera.getTopLeft().getX();
        int mazePosRelativeToMazeCamY = mazePosition.getY() - mazeCamera.getTopLeft().getY();

        return new TerminalPosition(getTopLeft().getX() + mazePosRelativeToMazeCamX * charsPerImage * charWidth,
                getTopLeft().getY() + mazePosRelativeToMazeCamY * charsPerImage * charHeight);
    }

}
