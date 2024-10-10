package com.g0301.mazerunner.model;

import com.g0301.mazerunner.model.game.MazePosition;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazePositionTest {

        @Property
        void getLeft(@ForAll int x, @ForAll int y) {
            assertEquals(x - 1, new MazePosition(x, y).getLeft().getX());
            assertEquals(y, new MazePosition(x, y).getLeft().getY());
        }

        @Property
        void getRight(@ForAll int x, @ForAll int y) {
            assertEquals(x + 1, new MazePosition(x, y).getRight().getX());
            assertEquals(y, new MazePosition(x, y).getRight().getY());
        }

        @Property
        void getUp(@ForAll int x, @ForAll int y) {
            assertEquals(x, new MazePosition(x, y).getUp().getX());
            assertEquals(y - 1, new MazePosition(x, y).getUp().getY());
        }

        @Property
        void getDown(@ForAll int x, @ForAll int y) {
            assertEquals(x, new MazePosition(x, y).getDown().getX());
            assertEquals(y + 1, new MazePosition(x, y).getDown().getY());
        }
}
