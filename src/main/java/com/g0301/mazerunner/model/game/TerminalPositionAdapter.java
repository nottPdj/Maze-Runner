package com.g0301.mazerunner.model.game;

import com.googlecode.lanterna.TerminalPosition;

public class TerminalPositionAdapter implements Position {

    private TerminalPosition terminalPosition;

    public TerminalPositionAdapter(int x, int y) {
        terminalPosition = new TerminalPosition(x, y);
    }

    @Override
    public int getX() {
        return terminalPosition.getColumn();
    }

    @Override
    public int getY() {
        return terminalPosition.getRow();
    }
}
