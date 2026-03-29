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
        return traversal(root).isBalanced;
    }

    private TreeInfo traversal(TreeNode node) {
        if(node == null) 
            return new TreeInfo(true, 0);
        var leftInfo = traversal(node.left);
        var rightInfo = traversal(node.right);
        var isBalanced = Math.abs(leftInfo.height - rightInfo.height) <= 1
            && leftInfo.isBalanced && rightInfo.isBalanced;
        var height = 1 + Math.max(leftInfo.height, rightInfo.height);
        return new TreeInfo(isBalanced, height);
    }

    static class TreeInfo {
        boolean isBalanced;
        int height;
        TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
