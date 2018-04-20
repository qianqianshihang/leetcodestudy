package medium;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class NotRepeatStr_3 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + ",result=" + lengthOfLongestSubstring("jbpnbwwd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        String result = "";
        int max = 0;
        int tempMax = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (max == chars.length - i) {
                break;
            }
            for (int j = i; j < chars.length; j++) {
                if (result.contains(String.valueOf(chars[j]))) {
                    max = Math.max(max, tempMax);
                    tempMax = 0;
                    result = "";
                    break;
                } else {
                    result = result + String.valueOf(chars[j]);
                    tempMax++;
                }
            }
        }
        max = Math.max(max, tempMax);
        return max;
    }
}
