// Revision - Ancestor check first , then visitor check in dfs.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency List
        var adjList = new HashMap<Integer, List<Integer>>();
        var visited = new HashSet<Integer>();
        var ancestor = new HashSet<Integer>();

        for(int i=0; i<numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        for(int[] preReq : prerequisites) {
            adjList.get(preReq[0]).add(preReq[1]);
        }

        // DFS to check if all courses can be visited without having a cycle.

        for(int i=0; i<numCourses; i++) {
            if(visited.contains(i)) continue;
            if(isCyclePresent(i, adjList, visited, ancestor)) return false;
        }
        return true;
    }

    private boolean isCyclePresent(int i, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Set<Integer> ancestor) {
        // Checkign ancestor first then visited
        if(ancestor.contains(i)) return true;
        if(visited.contains(i)) return false;
        
        ancestor.add(i);
        
        for(int preReq: adjList.get(i)) {
            if(isCyclePresent(preReq, adjList, visited, ancestor))
                return true;
        }
        visited.add(i);
        ancestor.remove(i);
        return false;
    }
}
