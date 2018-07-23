# leetcode 7 颠倒整数题解
给定一个 32 位有符号整数，将整数中的数字进行反转。

示例 1:
```
输入: 123
输出: 321
```
 示例 2:
```
输入: -123
输出: -321
```
示例 3:
```
输入: 120
输出: 21
```
注意:

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。

代码如下
``` java
class Solution {
       public int reverse(int x) {
        char[] charArr = String.valueOf(x).toCharArray();
        int i, j;
        if(x > 0) {
            i = 0;
            j = charArr.length - 1;
            while(i < j) {
                char t  = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = t;
                i++;
                j--;
            }
        } else {
            i = 1;
            j = charArr.length - 1;
            while(i < j) {
                char t  = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = t;
                i++;
                j--;
            }
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        String ansString = x > 0 ? String.valueOf(charArr) : String.valueOf(charArr).substring(1);
        if(max.length() <= ansString.length() && ansString.compareTo(max) > 0) {
            return 0;
        } else {
            int ans = Integer.valueOf(String.valueOf(charArr));
            return ans;
        }
    }
}
```