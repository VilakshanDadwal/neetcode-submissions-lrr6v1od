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
// Revision
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
       return diameter(root).diameter;
    }

    private TreeInfo diameter(TreeNode root) {
        if(root == null) return new TreeInfo(0,-1);
        var leftInfo = diameter(root.left);
        var rightInfo = diameter(root.right);
        var currentHeight = 1 + Math.max(leftInfo.height, rightInfo.height);
        var biggerSubTreeDiameter = Math.max(leftInfo.diameter, rightInfo.diameter);
        var diameterIncludingRoot = 2 + leftInfo.height + rightInfo.height;
        var currentDiameter = Math.max(biggerSubTreeDiameter, diameterIncludingRoot);
        return new TreeInfo(currentDiameter, currentHeight);
    }

    private class TreeInfo {
        int diameter;
        int height;
        TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
