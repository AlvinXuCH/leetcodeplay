package leetcodetest;

/**
 * 给定一个无序的整数数组，找到最长的连续递增序列
 * 例子： 【1，2，3，5，4】， 输出： 3
 * 【3，3，3】 输出： 1
 * Created by shunhe on 2021/3/21.
 */
public class LongestOrderedNums {

    public static int findLongestOrderedNum(int[] nums) {
        int longest = 0;
        int start = 0;
        int length = nums.length;
        int count = 1;
        if (nums.length == 0) {
            return 0;
        }
        while (start < length - 1) {
            if (nums[start] + 1 == nums[start + 1]) {
                count++;
            } else {
                if (longest < count) {
                    longest = count;
                }
            }
            start++;
        }
        return longest > count ? longest : count;
    }


    public static void main(String[] args) {
        System.out.println(findLongestOrderedNum(new int[]{3}));
        System.out.println(findLongestOrderedNum(new int[]{1, 2, 3, 5, 4}));
    }
}
