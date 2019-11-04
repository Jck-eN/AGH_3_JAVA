package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private Vector2d topRightCorner;
    private final Vector2d bottomLeftCorner = new Vector2d(0,0);

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
        return position.precedes(this.topRightCorner)
        && position.follows(this.bottomLeftCorner)
        && !this.isOccupied(position);
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
