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

    static class TreeInfo {
        TreeNode lca;
        int descsFound;
        TreeInfo(TreeNode lca, int descsFound) {
            this.lca = lca;
            this.descsFound = descsFound;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return lca(root, p, q).lca;
    }

    TreeInfo lca(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return new TreeInfo(null, 0);
        }
        var leftInfo = lca(node.left, p, q);
        var rightInfo = lca(node.right, p, q);

        if(leftInfo.lca != null) return leftInfo;
        if(rightInfo.lca != null) return rightInfo;

        var count = 0;

        if(node.val == p.val || node.val == q.val)
            count++;

        count += leftInfo.descsFound + rightInfo.descsFound;
        
        if(count ==2) return new TreeInfo(node, count);
        
        return new TreeInfo(null, count);
    }
}