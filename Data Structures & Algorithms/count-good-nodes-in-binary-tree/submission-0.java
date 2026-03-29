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
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    int goodNodes(TreeNode node, int maxTillNow) {
        if(node == null) return 0;
        if(node.val >= maxTillNow) {
            maxTillNow = node.val;
            return 1 + goodNodes(node.left, maxTillNow) + goodNodes(node.right, maxTillNow);
        } 
        return goodNodes(node.left, maxTillNow) + goodNodes(node.right, maxTillNow);
    }
}
