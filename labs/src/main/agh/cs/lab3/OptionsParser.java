package agh.cs.lab3;

import java.util.ArrayList;

public class OptionsParser {
    private static MoveDirection stringToMoveDirection(String s){
        switch(s){
            case "f":
            case "forward":
                return MoveDirection.FORWARD;
            case "b":
            case "backward":
                return MoveDirection.BACKWARD;
            case "l":
            case "left":
                return MoveDirection.LEFT;
            case "r":
            case "right":
                return MoveDirection.RIGHT;
            default: return null;
        }
    }
    public static MoveDirection[] parse(String[] beforeParse){
        ArrayList<MoveDirection> afterParse = new ArrayList<MoveDirection>();
        for(String s: beforeParse){
            MoveDirection singleDirection = stringToMoveDirection(s);
            if(singleDirection != null){
                afterParse.add(singleDirection);
            }
        }
        return afterParse.toArray(new MoveDirection[afterParse.size()]);
    }
}
