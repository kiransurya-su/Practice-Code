package leetcode_dcc.apr_26;
/*
2751. Robot Collisions (Hard)
There are n 1-indexed robots, each having a position on a line, health, and movement direction.
You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.
All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.
If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.
Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final health of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.
Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.
Note: The positions may be unsorted.
Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
Output: [2,17,9,15,10]
Explanation: No collision occurs in this example, since all robots are moving in the same direction. So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].

Streak->238
* */
import java.util.*;
public class RobotCollisions {
    public static void main(String[] args) {
        int[] positions = {5, 4, 3, 2, 1};
        int[] healths = {2, 17, 9, 15, 10};
        String directions = "RRRRR";
        System.out.println(survivedRobotsHealths(positions,healths,directions));
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->positions[a]-positions[b]);
        Stack<Integer> st = new Stack<>();
        for(int id:idx){
            if(directions.charAt(id)=='R'){
                st.push(id);
            }else{
                while(!st.isEmpty() && healths[id]>0){
                    int top=st.peek();
                    if(healths[id]>healths[top]){
                        healths[id]--;
                        healths[top]=0;
                        st.pop();
                    }
                    else if(healths[id]<healths[top]){
                        healths[id]=0;
                        healths[top]--;
                    }else{
                        healths[id]=0;
                        healths[top]=0;
                        st.pop();
                    }
                }
            }
        }
        List<Integer> li = new ArrayList<>();
        for(int he:healths){
            if(he>0)
                li.add(he);
        }
        return li;
    }
}
