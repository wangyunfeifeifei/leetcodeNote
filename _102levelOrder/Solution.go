package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	ret := [][]int{}
	walkTree(root, 0, &ret)
	return ret
}

func walkTree(root *TreeNode, level int, ret *[][]int) {
	if root == nil {
		return
	}
	if len(*ret) < level {
		*ret = append(*ret, []int{})
	}
	(*ret)[level] = append((*ret)[level], root.Val)
	if root.Left != nil {
		walkTree(root.Left, level + 1, ret)
	}
	if root.Right != nil {
		walkTree(root.Right, level + 1, ret)
	}
}
