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
    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        if(root == null) return result;
        var q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            var rightMostNode = q.peek();
            result.add(rightMostNode.val);
            int size = q.size();
            while(size>0) {
                var node = q.poll();
                if(node.right !=null) q.add(node.right);
                if(node.left !=null) q.add(node.left);
                size--;
            }
        }
        return result;
    }
}
