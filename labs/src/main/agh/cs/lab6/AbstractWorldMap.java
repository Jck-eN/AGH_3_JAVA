package agh.cs.lab6;

import agh.cs.lab6.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();

    protected void addAnimal(Animal a){
        this.animals.add(a);
        this.animalsMap.put(a.getPosition(), a);
    }

    public boolean place(Animal animal){
        if(!this.canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("na polu: " + animal.getPosition().toString() + " nie można umieścić zwierzęcia");
        }
        this.addAnimal(animal);
        return true;
    }

    public void run(MoveDirection[] directions){
        int i=0;
        int animalNumber = this.animals.size();
        for(MoveDirection dir : directions){
            Animal animalToMove = this.animals.get(i);
            this.animalsMap.remove(animalToMove.getPosition());
            animalToMove.move(dir);
            this.animalsMap.put(animalToMove.getPosition(), animalToMove);
            i=(i+1)%animalNumber;
        }
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }


    public Object objectAt(Vector2d position){
        return this.animalsMap.get(position);
    }

    abstract public Vector2d getTopRightCorner();

    abstract public Vector2d getBottomLeftCorner();

    public String toString() {
        return new MapVisualizer(this).draw(this.getBottomLeftCorner(), this.getTopRightCorner());
    }
}
