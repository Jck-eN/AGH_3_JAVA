package agh.cs.lab5;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    protected List<Grass> grasses = new ArrayList<>();



    public GrassField(int n){
        for(int i=0; i < n; i++) {
            addGrass(n);
        }
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
        this.grasses.add(new Grass(position));
    }

    public Object grassAt(Vector2d position){
        for(Grass g : this.grasses){
            if(g.getPosition().equals(position)){
                return g;
            }
        }
        return null;
    }

    public Object objectAt(Vector2d position){
        Object object = super.objectAt(position);
        if(object!=null) return object;

        return this.grassAt(position);
    }

    private Vector2d calculateTopRightCorner(){
        int max_x=Integer.MIN_VALUE;
        int max_y=Integer.MIN_VALUE;
        for(Animal a : this.animals){
            if(a.getPosition().x > max_x) max_x=a.getPosition().x;
            if(a.getPosition().y > max_y) max_y=a.getPosition().y;
        }
        for(Grass r : this.grasses){
            if(r.getPosition().x > max_x) max_x=r.getPosition().x;
            if(r.getPosition().y > max_y) max_y=r.getPosition().y;
        }
        return new Vector2d(max_x, max_y);
    }
    private Vector2d calculateBottomLeftCorner(){
        int min_x=Integer.MAX_VALUE;
        int min_y=Integer.MAX_VALUE;
        for(Animal a : this.animals){
            if(a.getPosition().x < min_x) min_x=a.getPosition().x;
            if(a.getPosition().y < min_y) min_y=a.getPosition().y;
        }
        for(Grass r : this.grasses){
            if(r.getPosition().x < min_x) min_x=r.getPosition().x;
            if(r.getPosition().y < min_y) min_y=r.getPosition().y;
        }
        return new Vector2d(min_x, min_y);
    }

    public void run(MoveDirection[] directions){
        int i=0;
        int animalNumber = this.animals.size();
        for(MoveDirection dir : directions){
            this.animals.get(i).move(dir);
            i=(i+1)%animalNumber;
            Object g = this.grassAt(this.animals.get(i).getPosition());
            if(g != null) {
                this.addGrass(this.grasses.size());
                this.grasses.remove(g);
            }
        }
    }

    public String toString(){
        return new MapVisualizer(this).draw(this.calculateBottomLeftCorner(), this.calculateTopRightCorner());
    }

    public boolean canMoveTo(Vector2d position){
                return !(this.objectAt(position) instanceof Animal);
    }



}
