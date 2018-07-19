import java.util.Arrays;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] arr = nums.clone();
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j --;
            }else {
                int[] ans = new int[]{-1, -1};
                boolean flag = true;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == nums[i] && flag) {
                        ans[0] = k;
                        flag = false;
                    } 
                    if (arr[k] == nums[j]) {
                        ans[1] = k;
                    }
                }
                return ans;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int[] ans = twoSum(arr, 9);
        for(int i:ans) {
            System.out.println(i);
        }
    }
}