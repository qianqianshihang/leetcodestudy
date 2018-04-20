package easy;

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*
* */

import java.util.*;

public class JewelsandStones_711 {
    public static void main(String[] args) {
        int i = numJewelsInStones("aA", "aAAbbbb");
        System.out.println("count=" + i);
    }

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        String[] keys = J.split("");
        String[] targets = S.split("");
        List<String> targetList = Arrays.asList(targets);
        ArrayList<String> target = new ArrayList<>(targetList);

        for (String key : keys) {
            ListIterator<String> listIterator = target.listIterator();
            while (listIterator.hasNext()){
                String next = listIterator.next();
                if (key.equals(next)) {
                    count++;
                    listIterator.remove();
                }
            }

        }
        return count;
    }
}
