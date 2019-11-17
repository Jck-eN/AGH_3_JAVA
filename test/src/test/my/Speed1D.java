package test.my;

public class Speed1D extends Speed{
    public int value;

    public Speed1D(int x){
        super(x);
        this.value = x;
    }
    public int getValue() {
        System.out.println("Speed1D");
        System.out.println(value);
        return value;
    }

}