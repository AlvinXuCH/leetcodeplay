import java.util.HashMap;
import java.util.Map;

/**
 * Created by shunhe on 2021/3/6.
 */
public class TestMain {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 6, 15};
        int target = 6;
        int[] result = twoSum(nums, target);
        int[] result12 = twoSumSimpleVersion(nums,target);
        System.out.println("done");
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{i, result.get(target - nums[i])};
            }
            result.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static int[] twoSumSimpleVersion(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
