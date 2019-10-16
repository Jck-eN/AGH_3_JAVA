package agh.cs.lab3;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return String.format("pozycja: %s%nkierunek: %s", position.toString(), direction.toString());
    }

    private boolean checkIfOnBoard(Vector2d newPosition){
        return newPosition.follows(new Vector2d(0,0)) && newPosition.precedes(new Vector2d(4,4));
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
                if (checkIfOnBoard(newPosition)) {
                    this.position = newPosition;
                }
                break;
            }
            case BACKWARD: {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (checkIfOnBoard(newPosition)) {
                    this.position = newPosition;
                }
                break;
            }
            default:
                return;
        }
    }
}
