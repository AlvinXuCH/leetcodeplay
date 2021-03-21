package leetcodetest;


/**
 * 获取最长子串的长度
 * leetcode: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * Created by shunhe on 2021/3/16.
 */
public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        String longestString = "";
        if (s.equals("")) {
            longest = 0;
        } else {
            int length = s.length();
            for (int i = 0; i < length; i++) {
                String currentChar = String.valueOf(s.charAt(i));
                if (longestString.contains(currentChar)) {
                    longestString = longestString.substring(longestString.indexOf(s.charAt(i)) + 1);
                    longestString = longestString.concat(currentChar);
                    if (longestString.length() > longest) {
                        longest = longestString.length();
                    }
                } else {
                    longestString = longestString.concat(currentChar);
                    if (longest < longestString.length()) {
                        longest = longestString.length();
                    }
                }
            }

        }

        return longest;
    }

    public static int refinedSolution(String s) {
        int longest = 0;
        int result = 0;
        int startFlag = 0;
        int length = s.length();
        if (length < 2) {
            return length;
        }
        for (int i = 0; i < length; i++) {
            int pos = s.indexOf(s.charAt(i), startFlag);
            if (pos < i) {
                if (result < longest) {
                    result = longest;

                }
                startFlag = pos + 1;
                longest = i - pos;
            } else {
                longest++;
            }
        }
        return result > longest ? result : longest;
    }


    public static int secondSolution(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i), flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(refinedSolution(""));
        System.out.println(refinedSolution("abcabcbb"));
        System.out.println(refinedSolution("abcadcbb"));
        System.out.println(refinedSolution("abba"));
        System.out.println(refinedSolution("pwwkew"));
    }
}
