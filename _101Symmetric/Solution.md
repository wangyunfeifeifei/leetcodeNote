# 101 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
```
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
```
```
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
```
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

题解：
```go
package main

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
```
