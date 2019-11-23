package agh.cs.lab7;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    protected List<Grass> grasses = new ArrayList<>();
    protected Map<Vector2d, Grass> grassesMap = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int n){
        for(int i=0; i < n; i++) {
            addGrass(n);
        }
    }

    public boolean place(Animal a){
        if(super.place(a)) {
            a.addObserver(this.mapBoundary);
            mapBoundary.addElement(a.getPosition());
            return true;
        }
        return false;
    }

    private void addGrass(int size){
        Vector2d position;
        Random r = new Random();
        do {
            int x = r.nextInt((int) (Math.sqrt(size * 10)));
            int y = r.nextInt((int) (Math.sqrt(size * 10)));
            position = new Vector2d(x, y);
        }
        while (this.isOccupied(position));
        Grass g = new Grass(position);
        mapBoundary.addElement(g.getPosition());
        this.grasses.add(g);
        this.grassesMap.put(g.getPosition(), g);
    }

    public Grass grassAt(Vector2d position){
        return this.grassesMap.get(position);
    }

    public Object objectAt(Vector2d position){
        Object object = super.objectAt(position);
        if(object!=null) return object;

        return this.grassAt(position);
    }

    public Vector2d getTopRightCorner(){
        return this.mapBoundary.getTopRight();
    }
    public Vector2d getBottomLeftCorner(){
        return this.mapBoundary.getBottomLeft();
    }

    public void run(MoveDirection[] directions){
        int i=0;
        int animalNumber = this.animals.size();
        for(MoveDirection dir : directions){

            Animal animalToMove = this.animals.get(i);
            animalToMove.move(dir);
            i=(i+1)%animalNumber;

            Grass g = this.grassAt(this.animals.get(i).getPosition());
            if(g != null) {
                this.addGrass(this.grasses.size());
                this.grasses.remove(g);
                this.grassesMap.remove(g.getPosition());
                this.mapBoundary.removeElement(g.getPosition());
            }
        }
    }


    public boolean canMoveTo(Vector2d position){
                return !(this.objectAt(position) instanceof Animal);
    }



}
