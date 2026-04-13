/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q).lca;
    }
    private Info lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Info(null, 0);
        }

        var left = lca(root.left, p, q);
        var right = lca(root.right, p, q);
        
        // If lca already found in a sub tree, return without any checks.
        if(left.lca !=null || right.lca !=null) {
            return left.lca != null ? left : right;
        }
        // Get count of descendatns found in sub trees
        var count = left.count + right.count;        
        // Check this first before checking count 2, because count can become 2 after incrementing.
        if(p == root || q == root) {
            count++;
        }
        // After all checks done, check if count becomes 2. 
        return count==2 ? new Info(root, count) : new Info(null, count);
    }

    static class Info {
        TreeNode lca;
        int count;

        Info(TreeNode lca, int count) {
            this.lca = lca;
            this.count = count;
        }
    }
}