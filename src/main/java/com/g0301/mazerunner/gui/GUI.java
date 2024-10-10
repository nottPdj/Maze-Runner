package com.g0301.mazerunner.gui;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.List;

public interface GUI {
    void clear();
    void refresh() throws IOException;
    void start() throws IOException;
    void close() throws IOException;
    void drawImage(int startX, int startY, int charWidth, int charHeight, List<String> image);
    void drawText(int startX, int startY, String text, TextColor color);
    void paintScreen(TextColor color);
    ACTION getNextAction() throws IOException;
    enum ACTION {UP, RIGHT, DOWN, LEFT, MAP, NONE, QUIT, ESCAPE, SELECT}
}
