# 实现 strStr()

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
```
输入: haystack = "hello", needle = "ll"
输出: 2
```
示例 2:
```
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

解答:
```go
func strStr(haystack string, needle string) int {
	word := make(map[string]int)
	needleLen := len(needle)
	if needleLen == 0 {
		return 0
	}
	for i := 0; i < len(needle) - 1; i++ {
		word[needle[i:i+1]] = needleLen - i - 1
	}
	return indexOf(haystack, needle, word)
}

func indexOf(haystack string, needle string, word map[string]int) int {
	nLen := len(needle)
	hLen := len(haystack)
	for i := nLen - 1; i < hLen; {
		key := 0
		for haystack[i-key] == needle[nLen-key-1] {
			key ++
			if nLen == key {
				return i - nLen + 1
			}
		}
		if word[haystack[i:i+1]] > 0 {
			i += word[haystack[i:i+1]]
		} else {
			i += nLen
		}
	}
	return -1
}
````