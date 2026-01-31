package oops.ExceptionHandling;

public class Pro1 {
    public static void main(String[] args) {
        int a=5,b=0;
        try{
            System.out.println(a/b);
        } catch (Exception e) {
            b=1;
            System.out.println("B is Zero");
        }
        System.out.println("HELLO!!");
    }
}
