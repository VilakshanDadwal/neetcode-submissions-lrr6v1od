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
    private int goodNodes(TreeNode node, int maxValue) {
        if(node == null) return 0;
        var leftGoodNodes = goodNodes(node.left, Math.max(node.val, maxValue));
        var rightGoodNodes = goodNodes(node.right, Math.max(node.val, maxValue));
        
        var totalGoodNodes = leftGoodNodes + rightGoodNodes;
        return node.val >= maxValue ? 1 + totalGoodNodes : totalGoodNodes;
    }
}
