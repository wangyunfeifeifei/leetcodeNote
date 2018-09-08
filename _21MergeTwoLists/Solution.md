# 合并链表


将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

题解:
```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}
    var pre *ListNode
	ans := new(ListNode)
	ret := ans
	for l1 != nil {
		if l2 != nil && l1.Val > l2.Val {
			ans.Val = l2.Val
			ans.Next = new(ListNode)
            pre = ans
			ans = ans.Next
			l2 = l2.Next
		} else {
			ans.Val = l1.Val
			ans.Next = new(ListNode)
            pre = ans
			ans = ans.Next
			l1 = l1.Next
		}
	}
	for l2 != nil {
		ans.Val = l2.Val
		ans.Next = new(ListNode)
        pre = ans
		ans = ans.Next
		l2 = l2.Next
	}
    pre.Next = nil
	return ret

}
```
