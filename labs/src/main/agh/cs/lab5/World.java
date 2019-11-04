package agh.cs.lab5;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {

        List<Rock> RockStack = new ArrayList<>();
        RockStack.add(new Rock(new Vector2d(-4, -4)));
        RockStack.add(new Rock(new Vector2d(7, 7)));
        RockStack.add(new Rock(new Vector2d(3, 6)));
        RockStack.add(new Rock(new Vector2d(2, 0)));

        args = "f b r l f f r r f f f f f f f f".split(" ");
        MoveDirection[] directions = new OptionsParser().parse(args);

        IWorldMap map = new UnboundedMap(RockStack);
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
