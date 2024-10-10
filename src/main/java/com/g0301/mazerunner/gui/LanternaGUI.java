package com.g0301.mazerunner.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class LanternaGUI implements GUI{
    private final Screen screen;

    private final Map<Character, TextColor> colorMap = Map.ofEntries(
            entry('a', new TextColor.RGB(139, 137, 139)),
            entry('b', new TextColor.RGB(156, 153, 156)),
            entry('c', new TextColor.RGB(90, 89, 90)),
            entry('d', new TextColor.RGB(127, 127, 127)),
            entry('e', new TextColor.RGB(120, 118, 120)),
            entry('f', new TextColor.RGB(106, 109, 106)),
            entry('g', new TextColor.RGB(99, 99, 99)),
            entry('A', new TextColor.RGB((int)(139 * 0.6), (int)(137 * 0.6), (int)(139 * 0.6))),
            entry('B', new TextColor.RGB((int)(156 * 0.6), (int)(153 * 0.6), (int)(156 * 0.6))),
            entry('C', new TextColor.RGB((int)(90  * 0.6), (int)(89 * 0.6), (int)(90 * 0.6))),
            entry('D', new TextColor.RGB((int)(127 * 0.6), (int)(127  * 0.6), (int)(127 * 0.6))),
            entry('E', new TextColor.RGB((int)(120 * 0.6), (int)(118 * 0.6), (int)(120 * 0.6))),
            entry('F', new TextColor.RGB((int)(106 * 0.6), (int)(109 * 0.6), (int)(106 * 0.6))),
            entry('G', new TextColor.RGB((int)(99 * 0.6), (int)(99 * 0.6), (int)(99 * 0.6))),
            entry('h', new TextColor.RGB(236,205,143)),
            entry('r', new TextColor.RGB(73, 94, 39)),
            entry('s', new TextColor.RGB(108, 128, 49)),
            entry('t', new TextColor.RGB(66, 85, 45)),
            entry('u', new TextColor.RGB(80, 105, 44)),
            entry('v', new TextColor.RGB(100, 114, 51)),
            entry('w', new TextColor.RGB(112, 146, 45)),
            entry('R', new TextColor.RGB((int)(73 * 0.6), (int)(94 * 0.6), (int)(39 * 0.6))),
            entry('S', new TextColor.RGB((int)(108 * 0.6), (int)(128 * 0.6), (int)(49 * 0.6))),
            entry('T', new TextColor.RGB((int)(66 * 0.6), (int)(85 * 0.6), (int)(45 * 0.6))),
            entry('U', new TextColor.RGB((int)(80 * 0.6), (int)(105 * 0.6), (int)(44 * 0.6))),
            entry('V', new TextColor.RGB((int)(100 * 0.6), (int)(114 * 0.6), (int)(51 * 0.6))),
            entry('W', new TextColor.RGB((int)(112 * 0.6), (int)(146 * 0.6), (int)(45 * 0.6))),
            entry('y', new TextColor.RGB(0, 255, 0)),
            entry('z', new TextColor.RGB(255, 0, 0)),
            entry('.', new TextColor.RGB(0, 0, 0)),
            entry('-', new TextColor.RGB(51, 51, 153)),
            entry('0', new TextColor.RGB(255, 255, 255)),
            entry('1', new TextColor.RGB(153, 0, 48)),
            entry('2', new TextColor.RGB(255, 242, 0)),
            entry('+', new TextColor.RGB(45,33,44)),
            entry('*', new TextColor.RGB(180,55,49)),
            entry(',', new TextColor.RGB(211,83,55)),
            entry('3', new TextColor.RGB(105,43,36)),
            entry('4', new TextColor.RGB(92,31,39)),
            entry('5', new TextColor.RGB(122,49,69)),
            entry('6', new TextColor.RGB(157,69,57)),
            entry('7', new TextColor.RGB(119,0,0)),
            entry('8', new TextColor.RGB(176,0,0)),
            entry('9', new TextColor.RGB(205,104,60)),
            entry('_', new TextColor.RGB(230,144,78))
    );

    public LanternaGUI(int width, int height, int fontSize) throws IOException {
        AWTTerminalFontConfiguration fontCfg = loadFontConfiguration(fontSize);
        Terminal terminal = createTerminal(width, height, fontCfg);
        this.screen = createScreen(terminal);
    }

    private AWTTerminalFontConfiguration loadFontConfiguration(int fontSize) {
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, fontSize);
        AWTTerminalFontConfiguration fontCfg = AWTTerminalFontConfiguration.newInstance(font);
        return fontCfg;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontCfg) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        Terminal terminal = new DefaultTerminalFactory()
                .setTerminalEmulatorTitle("Maze Runner")
                .setForceAWTOverSwing(true)
                .setInitialTerminalSize(terminalSize)
                .setTerminalEmulatorFontConfiguration(fontCfg)
                .createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        return screen;
    }

    private TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }

    @Override
    public void clear() {
        this.screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        this.screen.refresh(Screen.RefreshType.AUTOMATIC);
    }

    @Override
    public void start() throws IOException {
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    @Override
    public void close() throws IOException {
        this.screen.close();
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        while (screen.pollInput() != null);

        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.ESCAPE;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'm') return ACTION.MAP;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }
    @Override
    public void drawImage(int startX, int startY, int charWidth, int charHeight, List<String> image) {
        TextGraphics graphics = createTextGraphics();
        int y = startY;
        for (String line : image) {
            drawLine(line, startX, y, charWidth, charHeight, graphics);
            y += charWidth;
        }
    }

    public void drawLine(String line, int startX, int y, int charWidth, int charHeight, TextGraphics graphics) {
        int x = 0;
        for (int i =0;i<line.length();i++) {
            char c = line.charAt(i);
            if (c == ' ') {
                x += charWidth;
                continue;
            }
            graphics.setBackgroundColor(colorMap.get(c));

            graphics.fillRectangle(new TerminalPosition(startX + x, y),
                    new TerminalSize(charWidth, charHeight), ' ');
            x += charWidth;
        }
    }
@Override
    public void drawText(int startX, int startY, String text, TextColor color) {
        TextGraphics graphics = createTextGraphics();
        graphics.setForegroundColor(color);
        graphics.putString(new TerminalPosition(startX, startY), text, SGR.BOLD);
    }
    @Override
    public void paintScreen(TextColor color) {
        TextGraphics graphics = createTextGraphics();
        graphics.setBackgroundColor(color);
        // graphics.fill(' ');
        graphics.fillRectangle(new TerminalPosition(0, 0), graphics.getSize(), ' ');
    }
}