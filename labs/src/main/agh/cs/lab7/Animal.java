package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    private IWorldMap map;
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map){
        this.map = map;
        this.addObserver(map);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this(map);
        this.position = initialPosition;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        switch (this.direction){
            case NORTH: return "N";
            case EAST: return "E";
            case SOUTH: return "S";
            case WEST: return "W";
            default: throw new IllegalArgumentException("Niepoprawny kierunek zwierzęcia");
        }
    }
    public String toStringLong() {
        return String.format("pozycja: %s | kierunek: %s", position.toString(), direction.toString());
    }


    public void move(MoveDirection direction){
        switch(direction){
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD: {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if(map.canMoveTo(newPosition)){
                    this.positionChanged(this.position, newPosition);
                    this.position = newPosition;
                };
                break;
            }
            case BACKWARD: {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if(map.canMoveTo(newPosition)){
                    positionChanged(this.position, newPosition);
                    this.position = newPosition;
                };
                break;
            }
            default:
                throw new IllegalArgumentException("Nieprawidłowy kierunek!");
        }
    }

    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver o : observers){
           o.positionChanged(oldPosition, newPosition);
        }
    }

}
