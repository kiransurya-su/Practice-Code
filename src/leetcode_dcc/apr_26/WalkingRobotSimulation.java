package leetcode_dcc.apr_26;
/*
874. Walking Robot Simulation (Medium)
A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:
-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.
Return the maximum squared Euclidean distance that the robot reaches at any point in its path (i.e. if the distance is 5, return 25).

Note:
There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]

Output: 65

Explanation:

The robot starts at (0, 0):

Move north 4 units to (0, 4).
Turn right.
Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
Turn left.
Move north 4 units to (1, 8).
The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.

Streak->243
* */
import java.util.*;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(robotSim(commands,obstacles));

    }
    private static final long HASH_MULTIPLIER = 60013;
    public static int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Long> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(hash(obs[0], obs[1]));
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] currentPos = { 0, 0 };
        int max = 0;
        int currentDir = 0;
        for (int com : commands) {
            if (com == -1) {
                currentDir = (currentDir + 1) % 4;
                continue;
            }
            if (com == -2) {
                currentDir = (currentDir + 3) % 4;
                continue;
            }
            int[] direction = dirs[currentDir];
            for (int s = 0; s < com; s += 1) {
                int nx = currentPos[0] + direction[0];
                int ny = currentPos[1] + direction[1];
                if (obstacleSet.contains(hash(nx, ny)))
                    break;
                currentPos[0] = nx;
                currentPos[1] = ny;
            }
            max = Math.max(max, currentPos[0] * currentPos[0] + currentPos[1] * currentPos[1]);
        }
        return max;
    }
    private static long hash(long x, long y) {
        return x + HASH_MULTIPLIER * y;
    }
}
