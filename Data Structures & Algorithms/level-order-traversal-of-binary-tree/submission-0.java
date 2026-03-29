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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if(root != null) {
            var queue = new LinkedList<TreeNode>();
            queue.add(root);
            bfs(queue, result);
        }

        return result;
    }
    private void bfs(Queue<TreeNode> queue, List<List<Integer>> result) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            var current = new ArrayList<Integer>();
            while(size>0) {
                var node = queue.poll();
                current.add(node.val);
                if(node.left !=null) queue.add(node.left);
                if(node.right !=null) queue.add(node.right);
                size--;
            }
            result.add(current);
        }
    }
}
