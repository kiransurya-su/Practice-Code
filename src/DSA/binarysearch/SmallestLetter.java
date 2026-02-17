package DSA.binarysearch;

public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target='a';
        System.out.println(nextGreatestLetter(letters,target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(target>=letters[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return letters[left%letters.length];
    }
}
