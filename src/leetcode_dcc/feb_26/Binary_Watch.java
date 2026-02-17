package leetcode_dcc.feb_26;


/*
401. Binary Watch (Easy)
* * A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
For example, the below binary watch reads "4:51".
Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
The hour must not contain a leading zero.
For example, "01:00" is not valid. It should be "1:00".
The minute must consist of two digits and may contain a leading zero.
For example, "10:2" is not valid. It should be "10:02".
Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

Streak-> 194
* */

import java.util.*;
public class Binary_Watch {
    public static void main(String[] args) {
        int turnedOn=1;
        System.out.println(readBinaryWatch(turnedOn));
    }
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> li = new ArrayList<>();
        if(turnedOn>8) return li;
        for(int hr=0;hr<12;hr++){
            for(int min=0;min<60;min++){
                if(Integer.bitCount(hr)+Integer.bitCount(min)==turnedOn){
                    StringBuilder k = new StringBuilder();
                    k.append(hr).append(":");
                    if(min<10){
                        k.append("0");
                    }
                    k.append(min);
                    li.add(k.toString());
                }
            }
        }
        return li;
    }
}
