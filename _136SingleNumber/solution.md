## LeetCode136 仅出现一次的数题解
两个数组的交集 II
给定两个数组，写一个方法来计算它们的交集。

例如:
给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

注意：

   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
   我们可以不考虑输出结果的顺序。
跟进:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？  
#
这道题中有一个重要的提示，就是除了那一个数，其他数都出现两次  
初始化一个`num=0`然后与每一个数异或一次，  
因为其他每一个数都出现了两次，所以其他数异或完了应该依然是0
然后只剩下单独出现的那一个数了。  
代码如下：
```java
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i=0; i<nums.length;i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
```