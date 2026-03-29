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

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        var resultSum = 0;
        var depths = new ArrayList<int[]>();
        // Create list of depths.
        findDepths(nestedList, 1, depths);
        // Find max depth.
        var maxDepth = 1;
        for(int[] depthInfo : depths) {
            maxDepth = Math.max(maxDepth, depthInfo[1]);
        }
        for(int[] depthInfo: depths) {
            var num = depthInfo[0];
            var depth = depthInfo[1];
            var weight = maxDepth - depth + 1;
            resultSum+= weight * num;
        }

        return resultSum;
    }

    private void findDepths(List<NestedInteger> nestedList, int depth, List<int[]>depths) {
        for(NestedInteger nestedObj : nestedList) {
            if(nestedObj.isInteger()) {
                depths.add(new int[] {nestedObj.getInteger(), depth});
            } else {
                findDepths(nestedObj.getList(), depth+1, depths);
            }
        }
    }
}
