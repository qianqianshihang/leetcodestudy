package easy;

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
* */
public class ReverseWordsinaStringIII_557 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String hello = reverseWords("Let's take LeetCode contest");
        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + "\nresult=" + hello);
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            builder.append(reverseWord(split[i]));
            if (i != split.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static String reverseWord(String word) {
        char[] chars = word.toCharArray();
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
