package easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/keyboard-row/description/
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
* */
public class KeyboardRow_500 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String[] words = findWords2(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + "\nresult=" + Arrays.toString(words));
    }

    public static String[] findWords(String[] words) {
        String[] ones = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
        String[] twos = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
        List<String> oneStr = Arrays.asList(ones);
        List<String> twoStr = Arrays.asList(twos);

        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            String temp = word.toUpperCase();
            String[] split = temp.split("");
            boolean need = true;
            int num = 0;
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    num = oneStr.contains(split[i]) ? 1 : twoStr.contains(split[i]) ? 2 : 3;
                } else {
                    if (num != (oneStr.contains(split[i]) ? 1 : twoStr.contains(split[i]) ? 2 : 3)) {
                        need = false;
                        break;
                    }
                }
            }
            if (need) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);
    }

    public static String[] findWords2(String[] words) {
        String ones = "qwertyuiop";
        String twos = "asdfghjkl";
        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            String temp = word.toLowerCase();
            boolean need = true;
            int num = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (i == 0) {
                    num = ones.contains(String.valueOf(temp.charAt(i))) ? 1 : twos.contains(String.valueOf(temp.charAt(i))) ? 2 : 3;
                } else {
                    if (num != (ones.contains(String.valueOf(temp.charAt(i))) ? 1 : twos.contains(String.valueOf(temp.charAt(i))) ? 2 : 3)) {
                        need = false;
                        break;
                    }
                }
            }
            if (need) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);
    }
}
