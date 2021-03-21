package leetcodetest;

/**
 * Created by shunhe on 2021/3/17.
 */
public class MediumSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double result;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] total = new int[len1 + len2];

        if (len1 == 0) {
            total = nums2;
        } else if (len2 == 0) {
            total = nums1;
        } else {
            int size = total.length - 1;
            int temp1 = len1 - 1;
            int temp2 = len2 - 1;
            while (temp1 >= 0 && temp2 >= 0) {
                if (nums1[temp1] >= nums2[temp2]) {
                    total[size--] = nums1[temp1];
                    temp1--;
                } else {
                    total[size--] = nums2[temp2];
                    temp2--;
                }
            }

            if (temp1 >= 0) {
                for (int i = temp1; i >= 0; i--) {
                    total[size--] = nums1[i];
                }
            }

            if (temp2 >= 0) {
                for (int i = temp2; i >= 0; i--) {
                    total[size--] = nums2[i];
                }
            }
        }

        if ((len1 + len2) % 2 == 1) {
            result = Double.valueOf(total[(len1 + len2) / 2]);
        } else {
            result = (total[(len1 + len2) / 2 - 1] + total[(len1 + len2) / 2]) / 2.0;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{2,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
