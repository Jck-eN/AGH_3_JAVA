package agh.cs.lab2;

import agh.cs.lab2.MapDirection;
import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        Assert.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        Assert.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        Assert.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assert.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
    }
    @Test
    public void previousTest(){
        Assert.assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
        Assert.assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        Assert.assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        Assert.assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
    }
}
