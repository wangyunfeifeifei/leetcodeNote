# leetcode 第一题 TwoSum
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```
解题思路：
```
使用双指针，i=0;j=nums.length-1
将原数组拷贝一份
将原数组排序
将i，j位置上的元素相加，如果大了j--，小了i++
```
代码如下
``` java
class Solution {
    public int[] twoSum(int[] nums, int target) {
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
}
```