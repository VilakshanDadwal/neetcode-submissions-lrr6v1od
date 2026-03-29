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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var current = root;
        while(current != null) {
            if(current.val > p.val && current.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if(current.val < p.val && current.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return current;
            }
        }
        return null;
    }
}
