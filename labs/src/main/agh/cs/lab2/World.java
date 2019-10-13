package agh.cs.lab2;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));


        MapDirection dir1 = MapDirection.EAST;
        System.out.println(dir1.toString());
        dir1 = dir1.next();
        dir1 = dir1.next();
        System.out.println(dir1.toString());
        dir1 = dir1.previous();
        System.out.println(dir1.toString());
        Vector2d dir1vector = dir1.toUnitVector();
        System.out.println(dir1vector.toString());
    }
}
