package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;

public class Grass implements IMapElement {
    private Vector2d position;

    private List<Animal> animals = new ArrayList<>();

    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString() {
        return "*";
    }
}
