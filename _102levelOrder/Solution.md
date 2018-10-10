# 二叉树的层次遍历

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
```
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
```
题解:
```go
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

```
