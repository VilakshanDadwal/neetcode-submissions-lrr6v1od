/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Optimal Solution
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        // This solution assumes , there is always a valid answer present       
        // IF p or q found , we are returning that because, if the othe node is in the 
        // same sub tree, the node just found will be the lca. 
        // If not, then the other node will be found in the other sub tree. 
        if(root == p || root == q) return root;

        var left = lowestCommonAncestor(root.left, p , q);
        var right = lowestCommonAncestor(root.right, p, q);

        // Two nodes found in the two sub trees
        if(left !=null && right !=null) return root;

        // If this node did not find both nodes in its two sub trees 
        // Then either there one was found, or none was found 
        // Note that one node can represent two cases- Case 1 - only p or q was foudn and the descendant in same sub tree.
        // Cas 2 - only one p or q was found and the other descendant in the other sub tree. 
        return left !=null ? left : right;
    }
   
}