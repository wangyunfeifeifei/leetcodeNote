package main

type ListNode struct {
	Val int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	next := head.Next
	head.Next = nil
	for next.Next != nil {
		tmp := next.Next
		next.Next = head
		head = next
		next = tmp
	}
	next.Next = head
	return next
}

func main() {

}
