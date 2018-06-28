package leetcode._189RotateArray;

public class Solution {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k==0)return;
        if(k <= nums.length / 2) {
            moveR(nums, 0, k);
        } else {
            reverseArray(nums);
            moveR(nums, 0, nums.length - k);
            reverseArray(nums);
        }
    }
    public static void moveR(int[] nums, int index, int k) {
        int len = nums.length;
        while(index + k < len) {
            for(int i = 0; i < k; i++) {
                int anchor = len - k + i;
                int t = nums[index + i];
                nums[index + i] = nums[anchor];
                nums[anchor] = t;
            }
            index += k;
            k %= (len - index);
            if(k == 0) break;
        }
    }
    public static void reverseArray(int nums[]) {
        for(int i=0; i<nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        rotate(test, 38);

        for(int i : test) {
            System.out.print(i + " ");
        }
    }
}
