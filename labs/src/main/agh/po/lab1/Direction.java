package agh.po.lab1;

public enum Direction {
    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT;

    public static Direction fromString(String str){
        switch(str){
            case "f":
                return FORWARD;
            case "b":
                return BACKWARD;
            case "l":
                return LEFT;
            case "r":
                return RIGHT;
            default:
                return null;
        }
    }
}
