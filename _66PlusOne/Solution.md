# leetcode 66 加一
给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```
示例 2:
```
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```
代码:
``` java
class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for(int i=digits.length - 1; i >= 0; i--) {
            if (c == 0) {
                return digits;
            }
            int tmp = digits[i] + 1;
            c = tmp / 10;
            digits[i] = tmp % 10;
        }
        if (c != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i=1;i<digits.length;i++) {
                ans[i] = 0;
            }
            return ans;
        }
        return digits;
    }
}
```