package leetcode._26RemoveDuplicatesFromArray;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int i = 1;
        int cur = nums[0];
        int count = 1;
        for(int j=1;j<nums.length;j++) {
            if(nums[j] != cur) {
                cur = nums[j];
                nums[i++] = cur;
                count ++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        int a = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }
}
