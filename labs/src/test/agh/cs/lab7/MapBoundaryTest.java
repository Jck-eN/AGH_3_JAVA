package agh.cs.lab7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapBoundaryTest {

    MapBoundary m;
    GrassField map, map2;
    Animal a, b, c, d;

    @Before
    public void setUp(){

        this.map=new GrassField(0);
        this.a = new Animal(map, new Vector2d(0,11));
        this.b = new Animal(map, new Vector2d(3,4));
        this.c = new Animal(map, new Vector2d(1,4));
        this.d = new Animal(map, new Vector2d(20,10));
        map.place(a);
        map.place(b);
        map.place(c);
        map.place(d);

        String[] args = "f b r l f f r r f f f f f f f f".split(" ");
        MoveDirection[] directions = OptionsParser.parse(args);
        map2 = new GrassField(0);
        Animal a2 = new Animal(map, new Vector2d(2, 2));
        Animal b2 = new Animal(map, new Vector2d(3, 4));
        map2.place(a2);
        map2.place(b2);
        map2.run(directions);
    }

    @Test
    public void getTopRight() {
        assertEquals(this.map.mapBoundary.getTopRight(), new Vector2d(20,11));
        assertEquals(this.map2.mapBoundary.getTopRight(), new Vector2d(3,7));
    }

    @Test
    public void getBottomLeft() {
        assertEquals(this.map.mapBoundary.getBottomLeft(), new Vector2d(0,4));
        assertEquals(this.map2.mapBoundary.getBottomLeft(), new Vector2d(2,-1));
    }
}