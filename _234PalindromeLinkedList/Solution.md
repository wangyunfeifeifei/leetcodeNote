# 回文链表

请判断一个链表是否为回文链表。

示例 1:
```
输入: 1->2
输出: false
```
示例 2:
```
输入: 1->2->2->1
输出: true
```
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

题解
```go
package main

type ListNode struct {
	Val int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}
	clone := head
	midNode := findMiddle(head)
	midNode = reverseNode(midNode)
	for clone.Next != nil {
		if clone.Val != midNode.Val {
			return false
		}
		clone = clone.Next
		midNode = midNode.Next
	}
	return true
}

// 返回中间节点
func findMiddle(head *ListNode) *ListNode {
	toTail := head
	total := 1
	for toTail.Next != nil {
		total ++
		toTail = toTail.Next
	}
	midNode := head
	var mid int
	mid = total / 2 + 1
	for i := 0; i < mid - 1; i++ {
		midNode = midNode.Next
	}
	return midNode
}

func reverseNode(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	next := head.Next
	head.Next = nil
	for next.Next != nil {
		tmp := next.Next
		next.Next = head
		head =  next
		next = tmp
	}
	next.Next = head
	return next
}
```
