## LeetCode189旋转数组题解
### 题目说明
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:
```
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```

示例 2:
```
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的原地算法。
### 第一种题解
最开始想到的解法就是开辟一个等大小的数组，然后从`nums.length-k`开始  
填数,然后从头填数，这样就完成了数组的移位。
不过题中的要求是空间为O(1)的，所以这种方法行不通
### 第二种题解
然后我就开始使用模拟的方法来做，每次往右移动一个数字，重复  
k次，显然最后超时了。
### 第三种题解
接下来开始了漫长的思考,开始在草稿纸上不停的画，突然发现,  
如果先将后面的k位与前K位交换,然后问题又变成了后`len-k`个元素  
向右移动k位的子问题了。
例如 
```
 输入：[1,2,3,4,5,6,7] 和 k = 3
将后k位与前k位交换后
[5,6,7,4，1,2,3]
这样就变成后四个元素旋转k=3的子问题了
当k大于len的一半的时候，我就先将数组翻转，然后移动len-k位
然后再翻转回来
```
代码如下
```java
public class Solution {
    public void rotate(int[] nums, int k) {
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
    public void moveR(int[] nums, int index, int k) {
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
    public void reverseArray(int nums[]) {
        for(int i=0; i<nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }
}
```
### 第四种题解
这一种题解是上一种题解的基础上突然想到的  
上一种题解大于一半长度是先将数组旋转再操作  
然后就想到了可以全部通过旋转来完成这个操作
将前`len-k`旋转再将后`k`位旋转, 然后整体旋转  
这样就完成了平移k位的操作
代码如下
```java
public class Solution2 {
    public void rotate(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        reverseArray(nums,0, len-k-1);
        reverseArray(nums, len-k, len-1);
        reverseArray(nums, 0, len-1);
    }
    public void reverseArray(int[] nums, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
```