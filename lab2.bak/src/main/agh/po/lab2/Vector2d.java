package main.agh.po.lab2;

import java.util.Vector;

public class Vector2d {
    public final int x;
    public final int y;

    private int max(int x, int y) {
        if (x > y) return x;
        else return y;
    }

    private int min(int x, int y) {
        if (x < y) return x;
        else return y;
    }

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Vector2d secondVector) {
        return this.x < secondVector.x && this.y < secondVector.y;
    }

    public boolean larger(Vector2d secondVector) {
        return this.x > secondVector.x && this.y > secondVector.y;
    }

    public Vector2d upperRight(Vector2d secondVector) {
        Vector2d res = new Vector2d(max(this.x, secondVector.x), max(this.y, secondVector.y));
        return res;
    }

    public Vector2d lowerLeft(Vector2d secondVector) {
        Vector2d res = new Vector2d(min(this.x, secondVector.x), min(this.y, secondVector.y));
        return res;
    }

    public Vector2d add(Vector2d secondVector) {
        Vector2d res = new Vector2d(this.x + secondVector.x, this.y + secondVector.y);
        return res;
    }

    public Vector2d sub(Vector2d secondVector) {
        Vector2d res = new Vector2d(this.x - secondVector.x, this.y - secondVector.y);
        return res;
    }

    public boolean equals(Object second){
        if (second == this) return false;
        if (!(second instanceof Vector2d)) return false;

        Vector2d secondVector = (Vector2d) second;
        return (this.x == secondVector.x && this.y == secondVector.y);
    }
}
