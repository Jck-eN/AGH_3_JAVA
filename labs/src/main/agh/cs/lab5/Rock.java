package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Rock implements IMapElement{
    private Vector2d position;

    private List<Animal> animals = new ArrayList<>();

    public Rock(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString() {
        return "r";
    }
}
