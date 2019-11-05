package agh.cs.lab6;

public class World {
    public static void main(String[] args) {

        args = "f b r l f f r r f f f f f f f f".split(" ");
        MoveDirection[] directions = new OptionsParser().parse(args);

        IWorldMap map = new GrassField(5);
    //    IWorldMap map = new RectangularMap(10, 5);
        Animal a = new Animal(map);
        Animal b = new Animal(map,new Vector2d(3,4));
        map.place(a);
        map.place(b);
        System.out.println(map);
        map.run(directions);
        System.out.println(map);



    }

}
