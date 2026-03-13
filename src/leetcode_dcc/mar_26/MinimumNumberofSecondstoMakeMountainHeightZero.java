package leetcode_dcc.mar_26;
/*
3296. Minimum Number of Seconds to Make Mountain Height Zero (Medium)
You are given an integer mountainHeight denoting the height of a mountain.

You are also given an integer array workerTimes representing the work time of workers in seconds.

The workers work simultaneously to reduce the height of the mountain. For worker i:

To decrease the mountain's height by x, it takes workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x seconds. For example:
To reduce the height of the mountain by 1, it takes workerTimes[i] seconds.
To reduce the height of the mountain by 2, it takes workerTimes[i] + workerTimes[i] * 2 seconds, and so on.
Return an integer representing the minimum number of seconds required for the workers to make the height of the mountain 0.

Example 1:

Input: mountainHeight = 4, workerTimes = [2,1,1]

Output: 3

Explanation:

One way the height of the mountain can be reduced to 0 is:

Worker 0 reduces the height by 1, taking workerTimes[0] = 2 seconds.
Worker 1 reduces the height by 2, taking workerTimes[1] + workerTimes[1] * 2 = 3 seconds.
Worker 2 reduces the height by 1, taking workerTimes[2] = 1 second.
Since they work simultaneously, the minimum time needed is max(2, 3, 1) = 3 seconds.

Streak->219
* */
public class MinimumNumberofSecondstoMakeMountainHeightZero {
    public static void main(String[] args) {
        int mountainHeight = 4;int[] workerTimes ={2,1,1};
        System.out.println(minNumberOfSeconds(mountainHeight,workerTimes));
    }
    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0, right = 0,maxT = 0;
        for(int t : workerTimes){
            maxT = Math.max(maxT,t);
        }
        right = maxT * mountainHeight * (mountainHeight + 1)/2;

        while (left <= right) {
            long T = (left + right) / 2;
            int totalRemoved = 0;
            for (int t : workerTimes) {
                long x = (long) Math.floor(Math.sqrt(1 + 8 * T/t)- 1) / 2;
                totalRemoved += x;
            }

            if (totalRemoved >= mountainHeight) {
                right = T - 1;
            } else {
                left = T + 1;
            }
        }

        return left;
    }
}
