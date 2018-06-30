package leetcode._136SingleNumber;

public class Solution {
    public static int singleNumber(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++) {
            num = num ^ nums[i];
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,4};
        int ans = singleNumber(arr);
        System.out.println(ans);
    }
}
