package main

import "fmt"

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	pre := strs[0]
	for _, v := range strs {
		k := 0
		for i := 0; i < len(v); i++ {
			if i < len(pre) && v[i:i+1] == pre[i:i+1] {
				k++
			} else {
				break
			}
		}
		pre = pre[0:k]
	}
	return pre
}

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))
}
