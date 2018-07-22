# leetcode 344 反转字符串
请编写一个函数，其功能是将输入的字符串反转过来。

示例：
```
输入：s = "hello"
返回："olleh"
```
代码如下:
```java
class Solution {
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int i = 0, j = charArr.length - 1;
        while(i<j) {
            char t = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = t;
            i++;
            j--;
        }
        return String.valueOf(charArr);
    }
}
```