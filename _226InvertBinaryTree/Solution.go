/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func invertTree(root *TreeNode) *TreeNode {
    var copyroot *TreeNode
    if root != nil {
        copyroot = new(TreeNode)
    }
    copyTree(root, copyroot)
    return copyroot
}

func copyTree(root *TreeNode, copyroot *TreeNode) {
    if root != nil {
        if root.Right != nil {
            copyroot.Left = new(TreeNode)
        }
        copyTree(root.Right, copyroot.Left)
        copyroot.Val = root.Val
        if root.Left != nil {
            copyroot.Right = new(TreeNode)
        }
        copyTree(root.Left, copyroot.Right)
    }
}
