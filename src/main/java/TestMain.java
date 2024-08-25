import java.util.HashMap;
import java.util.Map;

/**
 * Created by shunhe on 2021/3/6.
 */
public class TestMain {


    public static void main(String[] args) {
//        int[] nums = new int[]{3, 4, 6, 15};
//        int target = 6;
//        int[] result = twoSum(nums, target);
//        int[] result12 = twoSumSimpleVersion(nums,target);
//        System.out.println("done");
//        String test = "123";
//        System.out.println(test.le);

        System.out.println(countSubstrings1("aba"));
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

    public static int countSubstrings(String s) {
        if(s == ""){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int totalCount = 0;
        int singleCharCount = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                singleCharCount++;
            }else{
                totalCount+=singleCharCount==1?1:singleCharCount*(singleCharCount-1);
                singleCharCount=1;
            }
        }
        return totalCount;
    }


    public static int countSubstrings1(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }


    public static int test(String s){
        int n = s.length(), ans = 0;
        for (int i=0;i<2*n-1;i++){
            int l = i/2,r=i/2+i%2;
            if(l>=0&&r<n&&s.charAt(l) == s.charAt(r)){
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

}
