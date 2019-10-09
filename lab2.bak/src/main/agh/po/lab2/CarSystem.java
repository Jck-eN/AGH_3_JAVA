package main.agh.po.lab2;

import main.agh.po.lab2.MapDirection;
import test.agh.po.lab2.MapDirectionTest;

import static java.lang.System.out;

public class CarSystem {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        out.println(position2);
        out.println(position1.add(position2));
        MapDirection dir1 = MapDirection.NORTH;
        out.println(dir1.toString());
        out.println(dir1.next());
        out.println(dir1.previous());
        Vector2d dir1Vector = dir1.toUnitVector();
        out.println(dir1Vector.toString());
    }
}
