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
    public List<List<Integer>> findLeaves(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        dfs(root, result); 
        return result;
    }
    private int dfs(TreeNode node, List<List<Integer>> result) {
        if(node == null) return -1;
        var currentHeight = 1 + Math.max(dfs(node.left, result)
                                        , dfs(node.right, result));
        // Height of current node can be present in the list already 
        // OR it can need a new ArrayList. If it needs a new arraylist, its index will be one more than current max height.
        // currentMaxHeight will be size of list-1 , so checking if currentHeight == size of list.
        if(currentHeight == result.size()) 
            result.add(new ArrayList<Integer>());
        result.get(currentHeight).add(node.val);
        return currentHeight;
    }
}
