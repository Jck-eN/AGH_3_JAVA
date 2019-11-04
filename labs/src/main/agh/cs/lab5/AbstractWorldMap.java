package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animals = new ArrayList<>();

    public boolean place(Animal animal){
        if(!this.canMoveTo(animal.getPosition())){
            return false;
        }
        this.animals.add(animal);
        return true;
    }

    public void run(MoveDirection[] directions){
        int i=0;
        int animalNumber = this.animals.size();
        for(MoveDirection dir : directions){
            this.animals.get(i).move(dir);
            i=(i+1)%animalNumber;
        }
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
}
