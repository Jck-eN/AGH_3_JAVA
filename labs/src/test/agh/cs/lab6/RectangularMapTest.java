package agh.cs.lab6;

import agh.cs.lab6.Animal;
import agh.cs.lab6.IWorldMap;
import agh.cs.lab6.MapDirection;
import agh.cs.lab6.OptionsParser;
import agh.cs.lab6.RectangularMap;
import agh.cs.lab6.Vector2d;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {

    RectangularMap map;
    Animal a, b, c, d;

    @Before
    public void setUp(){
        this.map=new RectangularMap(10,5);
        this.a = new Animal(map);
        this.b = new Animal(map, new Vector2d(3,4));
        this.c = new Animal(map);
        this.d = new Animal(map, new Vector2d(20,10));
    }

    @Test
    public void placeTest(){
        assertTrue(map.place(a));
        assertTrue(map.place(b));
        assertThrows(IllegalArgumentException.class , () -> map.place(c));
        assertThrows(IllegalArgumentException.class , () -> map.place(d));
    }

    @Test
    public void canMoveToTest(){
        map.place(a);
        map.place(b);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(new Vector2d(27, 2)));
        assertFalse(map.canMoveTo(new Vector2d(2, -1)));
    }

    @Test
    public void isOccupiedTest(){
        map.place(a);
        map.place(b);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    public void objectAtTest(){
        map.place(a);
        map.place(b);
        assertEquals(a, map.objectAt(new Vector2d(2, 2)));
        assertEquals(b, map.objectAt(new Vector2d(3, 4)));
    }


    @Test
    public void runTest(){
        map.place(a);
        map.place(b);

        map.run(OptionsParser.parse("f b r l f f r r f f f f f f f f".split(" ")));
        assertEquals(MapDirection.SOUTH, a.getDirection());
        assertEquals(MapDirection.NORTH, b.getDirection());
        assertEquals(new Vector2d(2, 0), a.getPosition());
        assertEquals(new Vector2d(3, 4), b.getPosition());

        map.run(OptionsParser.parse("l l l l f f f f".split(" ")));
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertEquals(MapDirection.SOUTH, b.getDirection());
        assertEquals(new Vector2d(2, 2), a.getPosition());
        assertEquals(new Vector2d(3, 2), b.getPosition());
    }

}