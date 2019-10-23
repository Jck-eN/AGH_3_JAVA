package agh.cs.lab4;

public enum MapDirection {
    NORTH, EAST,SOUTH, WEST ;


    public String toString() {
        switch(this){
            case EAST: return "Wschód";
            case SOUTH: return "Południe";
            case WEST: return "Zachód";
            case NORTH: return "Północ";
            default: return "";
        }
    }

    public MapDirection next(){
        int idx = (this.ordinal() + 1) % MapDirection.values().length;
        return MapDirection.values()[idx];
    }

    public MapDirection previous(){
        int idx = (this.ordinal() - 1 + MapDirection.values().length) % MapDirection.values().length;
        return MapDirection.values()[idx];
    }

    public Vector2d toUnitVector(){
        Vector2d vector;
        switch(this){
            case EAST:
                return new Vector2d(1,0);
            case WEST:
                return new Vector2d(-1, 0);
            case NORTH:
                return new Vector2d(0,1);
            case SOUTH:
                return new Vector2d(0,-1);
            default:
                return null;
        }

    }

}
