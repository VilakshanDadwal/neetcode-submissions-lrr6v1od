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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        var map = new HashMap<Integer, List<Integer>>();
        
        var minCol = 0;
        var maxCol = 0;

        var queue = new LinkedList<TreeInfo>();
        queue.add(new TreeInfo(root, 0));

        while(!queue.isEmpty()) {
            var treeInfo = queue.poll();
            var node = treeInfo.node;
            var col = treeInfo.col;
            
            map.computeIfAbsent(col, k -> new ArrayList<Integer>())
            .add(node.val);

            if(node.left !=null) queue.add(new TreeInfo(node.left, col-1));
            if(node.right !=null) queue.add(new TreeInfo(node.right, col+1));

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
        }

        var result = new ArrayList<List<Integer>>();
        for(int i=minCol; i<=maxCol; i++) {
            var colNums = map.get(i);
            result.add(colNums);
        }
        return result;
    }

    static class TreeInfo {
        private TreeNode node;
        private int col;
        TreeInfo(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}