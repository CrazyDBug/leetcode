package daily.question2560;

import java.util.Arrays;

/**
 * @date: 2023/9/19 22:57
 * @author: ybl
 */
public class Solution {
    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        int k = 2;
        new Solution().minCapability(nums,k);
    }
}
