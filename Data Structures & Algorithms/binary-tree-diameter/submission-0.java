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
    public int diameterOfBinaryTree(TreeNode root) {
         var result = diameter(root);
         return result.diameter;
    }

    private TreeInfo diameter(TreeNode node) {
        if(node == null)
            return new TreeInfo(0,-1);
        var leftInfo = diameter(node.left);
        var rightInfo = diameter(node.right);
        // Because length of path is no of edges, path through root 
        var pathThroughRoot = 2 + leftInfo.height + rightInfo.height;
        var subTreeMaxDiameter = Math.max(leftInfo.diameter, rightInfo.diameter);
        var currentMaxDiameter = Math.max(subTreeMaxDiameter, pathThroughRoot);
        return new TreeInfo(currentMaxDiameter, 1 + Math.max(leftInfo.height, rightInfo.height));
    }

    static class TreeInfo {
        int diameter;
        int height;
        TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
