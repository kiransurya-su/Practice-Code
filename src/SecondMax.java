public class SecondMax {
    public static void main(String[] args) {
        int[] arr = {1,2,5,67,89,100};
        int n1=Integer.MIN_VALUE;
        int n2=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>n1){
                n2=n1;
                n1=num;
            }else if(num>n2 && num!=n1){
                n1=num;
            }
        }
        System.out.println(n2);
    }
}
