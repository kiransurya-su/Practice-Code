import java.util.*;
public class Even_Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = {"Even","Odd"};
        System.out.println(arr[n%2]);
    }
}
