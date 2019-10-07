package test.agh.po.lab2;

import main.agh.po.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        assertEquals(new Vector2d(1,2), new Vector2d(1, 2));
    }
}
