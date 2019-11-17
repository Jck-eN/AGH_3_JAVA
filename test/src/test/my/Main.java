package test.my;

public class Main {

    public static void main(String[] args) {
	    Speed s1 = new Speed(12);
	    Speed1D s1d = new Speed1D(5);
	    Speed s2 = (Speed) s1d;
     //   s1.getValue();
        System.out.println(s1.value);
      //  s1d.getValue();
        System.out.println(s1d.value);
     //   s2.getValue();
        System.out.println(s2.value);
    }
}
