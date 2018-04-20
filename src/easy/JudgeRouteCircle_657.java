package easy;

import java.util.Arrays;
import java.util.Date;

/*
*
* Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
* */
public class JudgeRouteCircle_657 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        boolean ud = judgeCircle2("UD");
        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + ",result=" + ud);
    }

    public static boolean judgeCircle(String moves) {
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                left++;
            } else if (chars[i] == 'R') {
                right++;
            } else if (chars[i] == 'U') {
                top++;
            } else if (chars[i] == 'D') {
                bottom++;
            }
        }

        if (((left - right) == 0) && ((top - bottom) == 0)) {
            return true;
        }
        return false;
    }

    public static boolean judgeCircle2(String moves) {
        int left = 0;
        int top = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                left++;
            } else if (chars[i] == 'R') {
                left--;
            } else if (chars[i] == 'U') {
                top++;
            } else if (chars[i] == 'D') {
                top--;
            }
        }

        if (left == 0 && top == 0) {
            return true;
        }
        return false;
    }


}
