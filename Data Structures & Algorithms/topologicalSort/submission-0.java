class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        var result = new ArrayList<Integer>();
        var adjList = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        var visited = new HashSet<Integer>();
        var pathAncestors = new HashSet<Integer>();

        for(int i=0; i<n; i++) {
            // return empty list if cycle detected
            if(!dfs(i, adjList, visited, pathAncestors, result)) {
                return new ArrayList<Integer>();
            }
        }
        Collections.reverse(result);
        return result;
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Set<Integer> path, List<Integer> result) {
        if(visited.contains(src)) return true;
        if(path.contains(src)) return false;
        path.add(src);
        
        var neighbours = adjList.get(src);
        for(int neighbour : neighbours) {
            if(!dfs(neighbour, adjList, visited, path, result)) return false;
        }
        visited.add(src);
        path.remove(src);
        result.add(src);
        return true;// No cycle detected.
    }
}
