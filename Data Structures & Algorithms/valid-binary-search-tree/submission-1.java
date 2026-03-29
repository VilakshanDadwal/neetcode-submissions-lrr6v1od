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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, Integer.MIN_VALUE, root.val) 
                && isValidBST(root.right, root.val, Integer.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, int min, int max) {
        if(node == null) return true;
        if(node.val < max && node.val > min) {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
        return false;
    }
}
