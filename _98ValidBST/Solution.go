package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	} else if root.Left == nil && root.Right == nil{
		return true
	}
	out := []int{}
	walkTree(root, &out)
	for i := 1; i < len(out); i++ {
		if out[i - 1] >= out[i] {
			return false
		}
	}
	return true
}

func walkTree(root *TreeNode, out *[]int) {
	if root == nil {
		return
	}
	if root.Left != nil {
		walkTree(root.Left, out)
	}
	*out = append(*out, root.Val)
	if root.Right != nil {
		walkTree(root.Right, out)
	}
}

