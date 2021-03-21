package leetcodetest;

/**
 * 找最大回文子串
 * leetcode: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * Created by shunhe on 2021/3/18.
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        //边界条件判断
        if (s.length() < 2)
            return s;
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int start = 0, maxLen = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
            if (length - i <= maxLen / 2)
                break;
            int left = i, right = i;
            while (right < length - 1 && s.charAt(right + 1) == s.charAt(right))
                ++right; //过滤掉重复的
            //下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            //然后往两边判断，找出回文子串的长度
            while (right < length - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                ++right;
                --left;
            }
            //保留最长的
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        //截取回文子串
        return s.substring(start, start + maxLen);
    }


    public static String mySolution(String s) {


        if (s.length() < 2) {
            return s;
        }
        int length = s.length();
        int left = 0, right = 0;
        int start = 0;
        int maxlen = 0;
        for (int i = 0; i < length; i++) {
            left = i;
            right = i;

            while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right;
            while (right < length - 1 && left > 0 && s.charAt(left - 1) == s.charAt(right + 1)) {
                right++;
                left--;
            }
            if (right - left + 1 > maxlen) {
                maxlen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxlen);
    }


    public static void main(String[] args) {
//        longestPalindrome("baeaeac");

        System.out.println(mySolution("aacabdkacaa"));
//        System.out.println(mySolution("aa"));
    }
}
