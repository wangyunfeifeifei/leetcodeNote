package main

type ListNode struct {
	Val int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	toTail := head
	pre := head
	ret := head
	for i := 0; i< n-1; i++ {
		toTail = toTail.Next
	}
	for toTail.Next != nil {
		pre = head
		head = head.Next
		toTail = toTail.Next
	}
	if pre == head {
		return head.Next
	}
	pre.Next = head.Next
	return ret
}
