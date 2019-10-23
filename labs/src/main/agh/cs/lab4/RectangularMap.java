package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private Vector2d topRightCorner;
    private final Vector2d bottomLeftCorner = new Vector2d(0,0);

    private List<Animal> animals = new ArrayList<>();

    public Vector2d getTopRightCorner(){
        return this.topRightCorner;
    }

    public RectangularMap(int width, int height){
        this.topRightCorner = new Vector2d(width-1, height-1);
    }

    public String toString(){
        return new MapVisualizer(this).draw(this.bottomLeftCorner, this.topRightCorner);
    }

    public boolean canMoveTo(Vector2d position){
        if(position.precedes(this.topRightCorner)
        && position.follows(new Vector2d(0, 0))
        && !this.isOccupied(position)){
            return true;
        }
        return false;
    }

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
        for(Animal a : this.animals){
            if(a.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for(Animal a : this.animals){
            if(a.getPosition().equals(position)){
                return a;
            }
        }
        return null;
    }


}
