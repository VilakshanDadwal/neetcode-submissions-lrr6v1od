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
    public boolean isBalanced(TreeNode root) {
        return treeInfo(root).isBalanced;
    }

    TreeInfo treeInfo(TreeNode node) {
        if(node == null) return new TreeInfo(true, 0);
        var leftInfo = treeInfo(node.left);
        var rightInfo = treeInfo(node.right);
        var treeHeight = 1+ Math.max(leftInfo.height, rightInfo.height);
        if(!leftInfo.isBalanced || !rightInfo.isBalanced || 
                            (Math.abs(leftInfo.height - rightInfo.height) >1))
                            return new TreeInfo(false, treeHeight);
        return new TreeInfo(true, treeHeight);
    }
    class TreeInfo {
        boolean isBalanced;
        int height;
        TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
