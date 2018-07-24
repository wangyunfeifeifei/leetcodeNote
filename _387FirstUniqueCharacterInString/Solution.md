# leetcode 387 字符串中的第一个唯一字符

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
```
s = "leetcode"
返回 0.
```
```
s = "loveleetcode",
返回 2.
 ```

注意事项：您可以假定该字符串只包含小写字母。

代码如下：
``` java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (!map.containsKey(k)) {
                map.put(k, 0);
            }
            map.put(k, map.get(k) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;   
    }
}
```