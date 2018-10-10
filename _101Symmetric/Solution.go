package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	} else if root.Left == nil && root.Right == nil{
		return true
	}
	outL := []int{}
	outR := []int{}
	walkTreeL(root.Left, &outL)
	walkTreeR(root.Right, &outR)
	if len(outL) != len(outR) {
		return false
	}
	for i := 0; i < len(outL); i++ {
		if outL[i] != outR[i] {
			return false
		}
	}
	return true
}

func walkTreeL(root *TreeNode, out *[]int) {
	if root == nil {
		*out = append(*out, -1)
		return
	}
	*out = append(*out, root.Val)
	walkTreeL(root.Left, out)
	walkTreeL(root.Right, out)
}

func walkTreeR(root *TreeNode, out *[]int) {
	if root == nil {
		*out = append(*out, -1)
		return
	}
	*out = append(*out, root.Val)
	walkTreeR(root.Right, out)
	walkTreeR(root.Left, out)
}
