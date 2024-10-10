package com.g0301.mazerunner.model.game.elements;
import com.g0301.mazerunner.model.game.MazePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;


    @BeforeEach
    public void setUp() {
        player = new Player(2, 3);
    }

    @Test
    public void testGetPosition() {
        MazePosition position = new MazePosition(2, 3);
        assertEquals(position, player.getPosition());
    }

    @Test
    public void setPosition() {
        MazePosition position = new MazePosition(4, 5);

        player.setPosition(position);

        assertEquals(position, player.getPosition());
    }

    @Test
    public void isDead() {
        assertFalse(player.isdead());

        player.setDead(true);

        assertTrue(player.isdead());
    }


    @Test
    public void getImage() {
        player.indexImage(1);
        List<String> image = Arrays.asList(
                "                ",
                "                ",
                "     hh         ",
                "    ....        ",
                "   .0000.....   ",
                "  .z0000z.---.  ",
                " .00z00z0.----. ",
                " .000--00.----. ",
                " .000--00.----. ",
                " .00z00z0.----. ",
                "  .z0000z.---.  ",
                "   .0000.....   ",
                "    ....        ",
                "     hh         ",
                "                ",
                "                ");
        assertEquals(image, player.getImage());
    }


}
