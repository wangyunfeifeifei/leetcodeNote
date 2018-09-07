package main

import (
	"fmt"
	"strconv"
)

func countAndSay(n int) string {
	s := "1"
	for n > 1 {
		str := ""
		t := s[0:1]
		k := 1
		for i := 0; i < len(s); i++ {
			if s[i:i+1] != t {
				str = str+ strconv.Itoa(k-1) + t
				k = 1
				t = s[i:i+1]
			}
			k ++
		}
		str = str+ strconv.Itoa(k-1) + t
		n--
		s = str
	}
	return s
}

func main() {
	fmt.Println(countAndSay(6))
}
