package agh.cs.lab2;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        Assert.assertEquals(MapDirection.NORTH , MapDirection.SOUTH.next());
        Assert.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        Assert.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
    }
}
