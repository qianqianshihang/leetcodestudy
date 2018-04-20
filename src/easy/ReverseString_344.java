package easy;


import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString_344 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String hello = reverseString2("hello");
        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + "\nresult=" + hello);
    }

    public static String reverseString(String s) {
        List<String> list = Arrays.asList(s.split(""));
        Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
        }

        return stringBuilder.toString();
    }

    public static String reverseString2(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
