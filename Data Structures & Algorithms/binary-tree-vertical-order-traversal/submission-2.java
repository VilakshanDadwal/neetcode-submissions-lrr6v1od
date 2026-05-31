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
    static class NodeInfo {
        private TreeNode node;
        private int col;
        NodeInfo(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        var map = new HashMap<Integer, List<Integer>>();
        var queue = new LinkedList<NodeInfo>();
        var minCol = 0;
        var maxCol = 0;

        queue.add(new NodeInfo(root, 0));

        while(!queue.isEmpty()) {
            var nodeInfo = queue.poll();
            var node = nodeInfo.node;
            var col = nodeInfo.col;
            
            map.computeIfAbsent(col, k -> new ArrayList<Integer>())
                .add(node.val);
            
            if(node.left !=null) queue.add(new NodeInfo(node.left, col-1));
            if(node.right != null) queue.add(new NodeInfo(node.right, col+1));
            
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
        }

        var result = new ArrayList<List<Integer>>();
        
        for(int i=minCol; i<=maxCol; i++) {
            if(map.containsKey(i)) {
                result.add(map.get(i));
            }
        }

        return result;
    }
}