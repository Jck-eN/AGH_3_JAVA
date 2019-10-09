package agh.po.lab1;
import static java.lang.System.out;

public class CarSystem {
    private static void run(Direction[] args){
        for(Direction d : args){
            switch(d){
                case FORWARD:
                    out.println("Moving forward");
                    break;
                case BACKWARD:
                    out.println("Moving backward");
                    break;
                case LEFT:
                    out.println("Turns left");
                    break;
                case RIGHT:
                    out.println("Turns right");
                    break;
                default:
                    out.println("Something went wrong!");
            }
        }
    }

    public static void main(String[] args){
        out.println("Start");
        Direction[] dirs = new Direction[args.length];
        for(int i=0; i<args.length; i++){
            dirs[i] = Direction.fromString(args[i]);
        }
        run(dirs);
        out.println("Finish");
    }
}
