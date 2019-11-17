package agh.cs.lab7;

public class World {
    public static void main(String[] args) {
        try {
            args = "f b r l f f r r f f f f f f f f".split(" ");
            MoveDirection[] directions = OptionsParser.parse(args);

            GrassField map = new GrassField(5);
            //    IWorldMap map = new RectangularMap(10, 5);
            Animal a = new Animal(map);
            Animal b = new Animal(map, new Vector2d(3, 4));
            map.place(a);
            map.place(b);
            System.out.println(map);
            map.run(directions);
            System.out.println(map);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }


    }

}
