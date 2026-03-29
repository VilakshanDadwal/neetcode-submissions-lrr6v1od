// DFS revision
class Solution {
    public int countComponents(int n, int[][] edges) {
        var visited = new HashSet<Integer>();
        var adjList = new HashMap<Integer, List<Integer>>();
        // Create Adjacency List for undirected graph.
        for(int i=0; i<n; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        var noOfConnectedComponents = 0;
        // Do DFS for each node.
        for(int i=0; i<n; i++) {
            if(visited.contains(i)) continue; // Ignore if already visited. This also takes care of cycles.
            noOfConnectedComponents++; // If node is not visited, this is start of a connected component.
            dfs(i, adjList, visited);
        }
        return noOfConnectedComponents;
    }
    private void dfs(int i, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        visited.add(i); // 
        for(int neighbour: adjList.get(i)) {
            if(visited.contains(neighbour)) continue;
            dfs(neighbour, adjList, visited);
        }
    }
}
