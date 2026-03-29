/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


// BFS solution - removed duplicate maxDepth calculation
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        var currentDepth = 1;
        var maxDepth = 1;
        var depths = new ArrayList<int[]>();
        var q = new LinkedList<NestedInteger>();
        q.addAll(nestedList);
        
        while(!q.isEmpty()) {
            maxDepth = Math.max(maxDepth, currentDepth);
            var qSize = q.size();
            for(int i=0; i<qSize; i++) {
                var nestedInteger = q.poll();
                if(nestedInteger.isInteger()) {
                    depths.add(new int[]{nestedInteger.getInteger(), currentDepth});
                } else {
                    q.addAll(nestedInteger.getList());
                }
            }
            currentDepth++;
        }
        var resultSum=0;
        for(int[] depthInfo: depths) {
            var num = depthInfo[0];
            var depth = depthInfo[1];
            var weight = maxDepth - depth + 1;
            resultSum += weight * num;
        }
        
        return resultSum;
    }
}
