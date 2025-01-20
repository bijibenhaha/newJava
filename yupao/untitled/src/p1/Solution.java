package p1;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int arrayPairSum(int[] nums) {
        // 对nums进行排序
        Arrays.sort(nums);
        // 1，2，3，4
        // 0，1，2，3
        // 0，0+i*2,..,0+(n/2-1)*2
        int n = nums.length;
        n = n / 2;
        int max_sum = 0;
        for (int i = 0; i < n; i++) {
            max_sum += nums[i*2];
        }
        return max_sum;

    }
}

