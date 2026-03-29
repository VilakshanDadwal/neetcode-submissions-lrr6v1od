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
// DFS solution- Using levelSum/depthSum - (maxDepth-depth +1) * depthSum(orlevelSum) 
// Here (maxDepth-depth +1) is constant for numbers at a certain depth.
// so (Sum at a level) * (maxDepth-depth +1) for a single level can be calculated.
// then summing all such sums gives the answer.
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {

    Map<Integer, Integer> levelSum = new HashMap<>();

    int maxDepth = dfs(nestedList, 1, levelSum);

    int result = 0;

    for (int level : levelSum.keySet()) {
        result += levelSum.get(level) * (maxDepth - level + 1);
    }

    return result;
}

private int dfs(List<NestedInteger> list,
                int depth,
                Map<Integer, Integer> levelSum) {

    int maxDepth = depth;

    for (NestedInteger ni : list) {

        if (ni.isInteger()) {

            levelSum.put(depth,
                levelSum.getOrDefault(depth, 0) + ni.getInteger());

        } else {

            maxDepth = Math.max(maxDepth,
                    dfs(ni.getList(), depth + 1, levelSum));
        }
    }

    return maxDepth;
}
}
