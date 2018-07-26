# leetcode 125 验证回文字符串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
```
输入: "A man, a plan, a canal: Panama"
输出: true
```
示例 2:
```
输入: "race a car"
输出: false
```
代码如下:
``` java
class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (!isValid(s.charAt(i))) {
                i ++;
            } else if (!isValid(s.charAt(j))) {
                j --;
            } else if (!isEqual(s.charAt(i), s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    private boolean isEqual(char a, char b) {
        return a <= '9' && a >= '0' ? a == b : a == b || a - ('a' - 'A') == b || a + ('a' - 'A') == b;
    }
    private boolean isValid(char a) {
        return a <= '9' && a >= '0' || a <= 'z' && a >= 'a' || a <= 'Z' && a >= 'A';
    }
}
```
