package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private Vector2d topRightCorner;
    private final Vector2d bottomLeftCorner = new Vector2d(0,0);

    public Vector2d getTopRightCorner(){
        return this.topRightCorner;
    }
    public Vector2d getBottomLeftCorner(){
        return this.bottomLeftCorner;
    }

    public RectangularMap(int width, int height){
        this.topRightCorner = new Vector2d(width-1, height-1);
    }


    public boolean canMoveTo(Vector2d position){
        return position.precedes(this.topRightCorner)
        && position.follows(this.bottomLeftCorner)
        && !this.isOccupied(position);
    }



}
