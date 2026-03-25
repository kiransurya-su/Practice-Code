import java.util.Scanner;

public class ReplaceStarInLetterA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        StringBuilder k = new StringBuilder();
        int count=0;
        for(char ch:st.toCharArray()){
            if(ch=='A' || ch=='a'){
                count++;
                k.append("*".repeat(count));
            }else{
                k.append(ch);
            }
        }
        System.out.println(k.toString());
    }
}
