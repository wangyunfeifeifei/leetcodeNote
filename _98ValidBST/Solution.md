# 98 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:
```
输入:
    2
   / \
  1   3
输出: true
```
示例 2:
```
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
```
题解
```go
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


```