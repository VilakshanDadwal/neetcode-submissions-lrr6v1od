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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
    int goodNodes(TreeNode node, int maxValue) {
        if(node == null) return 0;
        var count = 0;
        if(node.val >= maxValue) {
            count = 1;
            maxValue = node.val;
        }
        return count + goodNodes(node.left, maxValue) + goodNodes(node.right, maxValue);
    }
}
