package agh.cs.lab5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest {

    IWorldMap map;
    Animal a, b, c, d;

    @Before
    public void setUp(){

        List<Rock> RockStack = new ArrayList<>();
        RockStack.add(new Rock(new Vector2d(-4, -4)));
        RockStack.add(new Rock(new Vector2d(7, 7)));
        RockStack.add(new Rock(new Vector2d(3, 6)));
        RockStack.add(new Rock(new Vector2d(2, 0)));

        this.map=new UnboundedMap(RockStack);
        this.a = new Animal(map);
        this.b = new Animal(map, new Vector2d(3,4));
        this.c = new Animal(map);
        this.d = new Animal(map, new Vector2d(20,10));
    }

    @Test
    public void placeTest(){
        assertTrue(map.place(a));
        assertTrue(map.place(b));
        assertFalse(map.place(c));
        assertTrue(map.place(d));
    }

    @Test
    public void canMoveToTest(){
        map.place(a);
        map.place(b);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(27, 2)));
        assertFalse(map.canMoveTo(new Vector2d(2, -1)));
        assertFalse(map.canMoveTo(new Vector2d(-4, -4)));
    }

    @Test
    public void isOccupiedTest(){
        map.place(a);
        map.place(b);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 6)));
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
        assertEquals(new Vector2d(2, 1), a.getPosition());
        assertEquals(new Vector2d(3, 5), b.getPosition());

        map.run(OptionsParser.parse("l l l l f f f f".split(" ")));
        assertEquals(MapDirection.NORTH, a.getDirection());
        assertEquals(MapDirection.SOUTH, b.getDirection());
        assertEquals(new Vector2d(2, 3), a.getPosition());
        assertEquals(new Vector2d(3, 3), b.getPosition());
    }

}