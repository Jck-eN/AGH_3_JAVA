package main.agh.po.lab2;

public enum MapDirection {
    NORTH("Północ"), EAST("Wschód"),SOUTH("Południe"), WEST("Zachód"), ;

    private String name;

    MapDirection(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
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
                vector = new Vector2d(0,1);
                return vector;
            case WEST:
                vector = new Vector2d(0, -1);
                return vector;
            case NORTH:
                vector = new Vector2d(1,0);
                return vector;
            case SOUTH:
                vector = new Vector2d(-1,0);
                return vector;
            default:
                vector = new Vector2d(0,0);
                return vector;
        }

    }

}
