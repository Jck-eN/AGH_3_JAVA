package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();

    private void addAnimal(Animal a){
        this.animals.add(a);
        this.animalsMap.put(a.getPosition(), a);
        a.addObserver(this.mapBoundary);
    }

    public boolean place(Animal animal){
        if(!this.canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("na polu: " + animal.getPosition().toString() + " nie można umieścić zwierzęcia");
        }
        this.addAnimal(animal);
        this.mapBoundary.addElement(animal.getPosition());
        return true;
    }

    public void run(MoveDirection[] directions){
        int i=0;
        int animalNumber = this.animals.size();
        for(MoveDirection dir : directions){
            Animal animalToMove = this.animals.get(i);
            animalToMove.move(dir);
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

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal a = this.animalsMap.get(oldPosition);
        this.animalsMap.remove(oldPosition);
        this.animalsMap.put(newPosition, a);
    }
}
