package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	return depth(root, 0)
}

func depth(root *TreeNode, dep int) int {
	if root == nil {
		return dep
	}
	l := depth(root.Left, dep + 1)
	r := depth(root.Right, dep + 1)
	if l > r {
		return l
	} else {
		return r
	}
}
