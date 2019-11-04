package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private List<Rock> rocks = new ArrayList<>();


    public UnboundedMap(List<Rock> rocks){
        this.rocks = rocks;
    }

    private Vector2d calculateTopRightCorner(){
        Vector2d topRight= new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Animal a : this.animals){
            if(a.getPosition().follows(topRight)) topRight=a.getPosition();
        }
        for(Rock r : this.rocks){
            if(r.getPosition().follows(topRight)) topRight=r.getPosition();
        }
        return topRight;
    }
    private Vector2d calculateBottomLeftCorner(){
        Vector2d bottomLeft= new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Animal a : this.animals){
            if(a.getPosition().precedes(bottomLeft)) bottomLeft=a.getPosition();
        }
        for(Rock r : this.rocks){
            if(r.getPosition().precedes(bottomLeft)) bottomLeft=r.getPosition();
        }
        return bottomLeft;
    }

    public String toString(){
        return new MapVisualizer(this).draw(this.calculateBottomLeftCorner(), this.calculateTopRightCorner());
    }

    public boolean canMoveTo(Vector2d position){
        if(position.follows(new Vector2d(0, 0))
                && !this.isOccupied(position)){
            return true;
        }
        return false;
    }


    public Object objectAt(Vector2d position){
        for(Animal a : this.animals){
            if(a.getPosition().equals(position)){
                return a;
            }
        }

        for(Rock r : this.rocks){
            if(r.getPosition().equals(position)){
                return r;
            }
        }
        return null;
    }


}
