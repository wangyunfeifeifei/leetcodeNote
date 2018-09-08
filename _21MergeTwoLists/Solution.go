package _21MergeTwoLists

type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLsits(l1 *ListNode, l2 *ListNode) *ListNode {
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
