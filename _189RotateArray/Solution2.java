package leetcode._189RotateArray;
//  第二种解法
public class Solution2 {
    public static void rotate(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        reverseArray(nums,0, len-k-1);
        reverseArray(nums, len-k, len-1);
        reverseArray(nums, 0, len-1);
    }
    public static void reverseArray(int[] nums, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    public static void main(String[] args) {
        int[] test = new int[] {1,2};
        rotate(test, 1);

        for(int i : test) {
            System.out.print(i + " ");
        }
    }
}
