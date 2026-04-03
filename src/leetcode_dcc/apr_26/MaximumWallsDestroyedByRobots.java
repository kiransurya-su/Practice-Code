package leetcode_dcc.apr_26;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
3661. Maximum Walls Destroyed by Robots (Hard)
There is an endless straight line populated with some robots and walls. You are given integer arrays robots, distance, and walls:
robots[i] is the position of the ith robot.
distance[i] is the maximum distance the ith robot's bullet can travel.
walls[j] is the position of the jth wall.
Every robot has one bullet that can either fire to the left or the right at most distance[i] meters.

A bullet destroys every wall in its path that lies within its range. Robots are fixed obstacles: if a bullet hits another robot before reaching a wall, it immediately stops at that robot and cannot continue.

Return the maximum number of unique walls that can be destroyed by the robots.

Notes:

A wall and a robot may share the same position; the wall can be destroyed by the robot at that position.
Robots are not destroyed by bullets.
* */
public class MaximumWallsDestroyedByRobots {
    public static void main(String[] args) {
        int[] robots = {4};
        int[] distance = {3};
        int[] walls = {1, 10};
        System.out.println(maxWalls(robots,distance,walls));
    }
    public static int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] num = new int[n];
        Map<Integer, Integer> robotsToDistance = new HashMap<>();

        for (int i = 0; i < n; i++) {
            robotsToDistance.put(robots[i], distance[i]);
        }

        Arrays.sort(robots);
        Arrays.sort(walls);

        int m = walls.length;
        int rightPtr = 0;
        int leftPtr = 0;
        int curPtr = 0;
        int robotPtr = 0;

        for (int i = 0; i < n; i++) {
            while (rightPtr < m && walls[rightPtr] <= robots[i]) {
                rightPtr++;
            }
            int pos1 = rightPtr;

            while (curPtr < m && walls[curPtr] < robots[i]) {
                curPtr++;
            }
            int pos2 = curPtr;

            int leftBound = robots[i] - robotsToDistance.get(robots[i]);
            if (i >= 1) {
                leftBound = Math.max(
                        robots[i] - robotsToDistance.get(robots[i]),
                        robots[i - 1] + 1
                );
            }
            while (leftPtr < m && walls[leftPtr] < leftBound) {
                leftPtr++;
            }
            int leftPos = leftPtr;
            left[i] = pos1 - leftPos;

            int rightBound = robots[i] + robotsToDistance.get(robots[i]);
            if (i < n - 1) {
                rightBound = Math.min(
                        robots[i] + robotsToDistance.get(robots[i]),
                        robots[i + 1] - 1
                );
            }
            while (rightPtr < m && walls[rightPtr] <= rightBound) {
                rightPtr++;
            }
            int rightPos = rightPtr;
            right[i] = rightPos - pos2;

            if (i == 0) {
                continue;
            }
            while (robotPtr < m && walls[robotPtr] < robots[i - 1]) {
                robotPtr++;
            }
            int pos3 = robotPtr;
            num[i] = pos1 - pos3;
        }

        int subLeft = left[0];
        int subRight = right[0];
        for (int i = 1; i < n; i++) {
            int currentLeft = Math.max(
                    subLeft + left[i],
                    subRight -
                            right[i - 1] +
                            Math.min(left[i] + right[i - 1], num[i])
            );
            int currentRight = Math.max(
                    subLeft + right[i],
                    subRight + right[i]
            );
            subLeft = currentLeft;
            subRight = currentRight;
        }

        return Math.max(subLeft, subRight);
    }
}
