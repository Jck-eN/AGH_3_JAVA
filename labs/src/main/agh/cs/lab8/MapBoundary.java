package agh.cs.lab8;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private SortedSet<Vector2d> elements_x = new TreeSet<>(new Comparator<Vector2d>() {
        public int compare(Vector2d o1, Vector2d o2) {
            int res =  o1.x - o2.x;
            if(res != 0) return res;
            else return o1.y - o2.y;
        }
    });
    private SortedSet<Vector2d> elements_y = new TreeSet<>(new Comparator<Vector2d>() {
        public int compare(Vector2d o1, Vector2d o2) {
            int res =  o1.y - o2.y;
            if(res != 0) return res;
            else return o1.x - o2.x;
        }
    });

    public void addElement(Vector2d element){
        elements_x.add(element);
        elements_y.add(element);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elements_x.remove(oldPosition);
        elements_y.remove(oldPosition);
        elements_x.add(newPosition);
        elements_y.add(newPosition);
    }

    private void validate(){
        if(elements_x.isEmpty() || elements_y.isEmpty()){
            throw new IllegalStateException("Mapboundary doesn't contain any points");
        }
    }

    public Vector2d getTopRight(){
        validate();
        return new Vector2d(elements_x.last().x, elements_y.last().y);
    }

    public Vector2d getBottomLeft(){
        validate();
        return new Vector2d(elements_x.first().x, elements_y.first().y);
    }

}
