package main

import "fmt"

type RLEIterator struct {
	data []int
}

func Constructor(A []int) RLEIterator {
	ret := new(RLEIterator)
	ret.data = A
	return *ret
}

func (this *RLEIterator) Next(n int) int {
	if len(this.data) == 0 {
		return -1
	}
	if this.data[0] >= n {
		ret := this.data[1]
		this.data[0] -= n
		return ret
	}
	for {
		if len(this.data) == 0 {
			return -1
		}
		if this.data[0] >= n {
			ret := this.data[1]
			this.data[0] -= n
			return ret
		}
		n -= this.data[0]
		this.data = this.data[2:]
	}
	ret := this.data[1]
	return ret
}

func main(){
	obj := Constructor([]int{3,8,0,9,2,5})
	fmt.Println(obj)
	fmt.Println(obj.Next(2))
	fmt.Println(obj.Next(1))
	fmt.Println(obj.Next(1))
	fmt.Println(obj.Next(2))
}
