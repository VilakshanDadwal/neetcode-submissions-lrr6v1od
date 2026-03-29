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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var inOrderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, 0, inorder.length-1, inOrderMap);
    }

    private TreeNode buildTree(int[] preOrder, int rootIdx, int leftIdx, int rightIdx, Map<Integer, Integer> inOrderMap) {
        if(leftIdx > rightIdx) return null;
        int rootValue = preOrder[rootIdx];
        var rootNode = new TreeNode(rootValue);
        var inOrderRootIdx = inOrderMap.get(rootValue);
        var leftSubTreeSize = inOrderRootIdx - leftIdx;
        rootNode.left = buildTree(preOrder, rootIdx+1, leftIdx, inOrderRootIdx-1, inOrderMap);
        rootNode.right = buildTree(preOrder, rootIdx + 1 + leftSubTreeSize, inOrderRootIdx+1, rightIdx, inOrderMap);
        return rootNode;
    }
}
