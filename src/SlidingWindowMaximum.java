import java.util.*;

// Using Deque
public class SlidingWindowMaximum {
    public static void main(String[] args) {
       int[] arr = {1,3,-1,-3,5,3,6,7};
       int k = 3;
       System.out.println(maxSlidingWindow(arr,k));
    }
    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        List<Integer> li = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) dq.pollLast();
            dq.addLast(i);
            if(i>=k-1) li.add(arr[dq.peekFirst()]);
        }
        return li;
    }
}
