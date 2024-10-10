package com.g0301.mazerunner;

import com.g0301.mazerunner.model.menu.MainMenu;
import com.g0301.mazerunner.states.MainMenuState;
import com.g0301.mazerunner.states.State;
import com.g0301.mazerunner.states.GameState;
import com.g0301.mazerunner.strategy.DayStrategy;
import com.g0301.mazerunner.view.game.GameViewer;

import java.io.IOException;

public class Game {
    private State state;
    private State gameState;
    public final static int MENU_WIDTH = 80;
    public final static int MENU_HEIGHT = 30;
    public final static int MENU_FONT_SIZE = 20;
    public final static int GAME_WIDTH = GameViewer.charWidth * GameViewer.charsPerImage * DayStrategy.camWidth;
    public final static int GAME_HEIGHT = GameViewer.charHeight * GameViewer.charsPerImage * DayStrategy.camHeight;
    public final static int GAME_FONT_SIZE = 1;
    public final static int MAP_FONT_SIZE = 1;

    private Game() throws IOException {
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Game().run();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void saveGameState(State gameState) {
        this.gameState = gameState;
    }

    public void loadGameState() throws IOException {
        gameState.unpause();
        state = gameState;
    }

    public State getState() {return state;}

    private void run() throws IOException, InterruptedException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }

    }
}