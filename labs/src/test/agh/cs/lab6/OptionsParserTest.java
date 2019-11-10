package agh.cs.lab6;

import agh.cs.lab6.MoveDirection;
import agh.cs.lab6.OptionsParser;
import org.junit.Before;
import org.junit.Test;

import static agh.cs.lab6.MoveDirection.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

public class OptionsParserTest {
    String[] s1, s2, s3, s4, s5;
    MoveDirection[] d1, d2, d3, d4, d5;
    @Before
    public void setUp()  {
        s1 = new String[]{"l", "left"};
        s2 = new String[]{"f", "forward"};
        s3 = new String[]{"r", "right"};
        s4 = new String[]{"b", "backward"};
        s5 = new String[]{"f", "backward", "test", "something", "right", "java", "l"};

        d1 = new MoveDirection[]{LEFT, LEFT};
        d2 = new MoveDirection[]{FORWARD, FORWARD};
        d3 = new MoveDirection[]{RIGHT, RIGHT};
        d4 = new MoveDirection[]{BACKWARD, BACKWARD};
        d5 = new MoveDirection[]{FORWARD, BACKWARD, RIGHT, LEFT};
    }

    @Test
    public void parseTest() {
        assertArrayEquals(OptionsParser.parse(s1), d1);
        assertArrayEquals(OptionsParser.parse(s2), d2);
        assertArrayEquals(OptionsParser.parse(s3), d3);
        assertArrayEquals(OptionsParser.parse(s4), d4);
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(s5));
    }
}