package test.my;

public class Speed{
    public int value;
    public Speed(int x){
        this.value = -10;
    }

    private int getValue() {
        System.out.println("Speed");
        System.out.println(value);
        return value;
    }
}
