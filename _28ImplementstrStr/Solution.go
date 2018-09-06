package main

import "fmt"

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

func main() {
	i := strStr("hello", "lo")
	fmt.Println(i)
}
