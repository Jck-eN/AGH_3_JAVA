package agh.cs.lab7;

import agh.cs.lab7.*;
import agh.cs.lab7.Animal;
import agh.cs.lab7.GrassField;
import agh.cs.lab7.MapDirection;
import agh.cs.lab7.OptionsParser;
import agh.cs.lab7.Vector2d;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrassFieldTest {

    GrassField map;
    Animal a, b, c, d;

    @Before
    public void setUp(){
        this.map=new GrassField(10);
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
        assertTrue(map.place(d));
    }

    @Test
    public void canMoveToTest(){
        map.place(a);
        map.place(b);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(27, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, -1)));
        assertFalse(map.canMoveTo(new Vector2d(3, 4)));
    }

    @Test
    public void isOccupiedTest(){
        map.place(a);
        map.place(b);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
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
        assertEquals(new Vector2d(2, -1), a.getPosition());
        assertEquals(new Vector2d(3, 7), b.getPosition());

        map.run(OptionsParser.parse("l l l l f f f f".split(" ")));
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertEquals(MapDirection.SOUTH, b.getDirection());
        assertEquals(new Vector2d(2, 1), a.getPosition());
        assertEquals(new Vector2d(3, 5), b.getPosition());
    }

    @Test
    public void grassSpawningTest() {
        assertEquals(this.map.grasses.size(), 10);
        GrassField map2 = new GrassField(5);
        assertEquals(map2.grasses.size(), 5);
    }

}