package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.Vector2d;

public class World {
    public static void main(String[] args) {

        Animal a = new Animal();
        System.out.println(a);
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection dir : directions) {
            a.move(dir);
        }
        System.out.println(a);
    }
}
