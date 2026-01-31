import java.util.*;
public class SortedWords {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        Arrays.sort(st);
        for(String s:st) System.out.print(s+" ");
    }
}