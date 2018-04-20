package easy;

import java.util.ArrayList;
import java.util.List;

/*
*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
* */
public class SelfDividingNumbers_728 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        List<Integer> results = selfDividingNumbers(1, 22);
        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + "\n,result=" + results);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (left <= right) {
            integers.add(left);
            int temp = left;
            while (temp > 0) {
                int num = temp % 10;
                if (num == 0) {
                    integers.remove(Integer.valueOf(left));
                    break;
                } else if (left % num != 0) {
                    integers.remove(Integer.valueOf(left));
                    break;
                }
                temp = temp / 10;
            }
            ++left;
        }
        return integers;
    }
}
