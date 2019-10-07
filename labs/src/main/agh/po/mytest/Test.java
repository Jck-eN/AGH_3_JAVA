package agh.po.test;
import static java.lang.System.out;

public class Test {
    public static void main(String[] args) {
        float a = 0.0f;
        float b = 0.001f;
        for(int i=0; i < 1000; i++){
            a += b;
        }
        out.println(a);
        if(a == 1.0){
            out.println("Wartości są identyczne");
        } else {
            out.println("Wartości nie są identyczne");
        }
    }
}
