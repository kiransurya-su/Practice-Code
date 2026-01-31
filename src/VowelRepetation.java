import java.util.*;
public class VowelRepetation {
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        StringBuilder k=new StringBuilder();
        for(String s:st){
            if("AEIOUaeiou".indexOf(s.charAt(0))!=-1){
                k.append(s).append(" ").append(s).append(" ");
            }else{
                k.append(s).append(" ");
            }
        }
        System.out.println(k);
    }
}
