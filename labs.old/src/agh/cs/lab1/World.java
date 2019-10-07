package agh.cs.lab1;

public class World {

    public static void run(Direction arg[]){
        for(Direction s : arg){
            if(s!=null) {
                switch (s) {
                    case FORWARD:
                        System.out.println("Pet goes front.");
                        break;
                    case BACKWARD:
                        System.out.println("Pet goes back.");
                        break;
                    case LEFT:
                        System.out.println("Pet turns left.");
                        break;
                    case RIGHT:
                        System.out.println("Pet turns right.");
                        break;
                    default:
                        break;
                }
            }
        }
        return;
    }

    public static Direction[] convert(String arg[]){
        Direction[] res = new Direction[arg.length];
        int i=0;
        for(String s : arg){
            switch(s){
                case "f":
                    res[i] = Direction.FORWARD;
                    i++;
                    break;
                case "b":
                    res[i] = Direction.BACKWARD;
                    i++;
                    break;
                case "l":
                    res[i] = Direction.LEFT;
                    i++;
                    break;
                case "r":
                    res[i] = Direction.RIGHT;
                    i++;
                    break;
                default:
                    break;
            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println("Hello World!");
        Direction[] dirs = convert(args);
        run(dirs);
        System.out.println("Bye!");
        return;
    }
}
