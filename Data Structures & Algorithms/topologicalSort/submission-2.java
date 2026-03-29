class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        var result = new ArrayList<Integer>();
        var visited = new HashSet<Integer>();
        var adjList = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for(int edge[]: edges) {
            adjList.get(edge[1]).add(edge[0]);        
        }

        var currentPath = new HashSet<Integer>();

        for(int i=0; i<n; i++) {
            if(dfs(i, adjList, visited, currentPath, result))
                return new ArrayList<Integer>();
        }
        //Collections.reverse(result);
        return result;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Set<Integer> currentPath, List<Integer> result) {
        if(visited.contains(node)) return false;
        if(currentPath.contains(node)) return true;
        currentPath.add(node);
        for(int neighbour: adjList.get(node)) {
            if(dfs(neighbour, adjList, visited, currentPath, result))
                return true;
        }
        currentPath.remove(node);
        visited.add(node);
        result.add(node);
        return false;
    }
}
