# 二叉树的最大深度

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
```
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 
```
题解:
```go
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

```