package main

import (
	"fmt"
)

func myAtoi(str string) int {
	const max int = 0x7fffffff
	const min int = -0x80000000
	idx := 0
	for idx < len(str) && str[idx] == ' ' {
		idx ++
	}
	flag := true
	if idx < len(str) && str[idx] == '-' {
		flag = false
		idx ++
	} else if idx < len(str) && str[idx] == '+' {
		idx ++
	}
	ans := 0
	for idx < len(str) {
		if str[idx] > '9' || str[idx] < '0' {
			break
		}
		ans = ans * 10 + (int)(str[idx] - '0')
		idx ++
		if ans > max {
			if flag {
				return max
			} else {
				return min
			}
		}
	}
	if flag {
		return ans
	} else {
		return -ans
	}
}

func main() {
	a := myAtoi("-42")
	fmt.Println(a)
}
