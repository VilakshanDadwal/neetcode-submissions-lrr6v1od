/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false; // If root is null , there is no tree.
        if(subRoot == null) return true; // Empty tree is a subRoot of any other tree.

        if(isSameTree(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode node, TreeNode subTreeNode) {
        if(node == null && subTreeNode == null) return true;
        if(node == null || subTreeNode == null) return false;

        return node.val == subTreeNode.val 
        && isSameTree(node.left, subTreeNode.left)
        && isSameTree(node.right, subTreeNode.right);
    }
}
