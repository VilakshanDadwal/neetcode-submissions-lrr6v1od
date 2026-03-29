class Solution {
    public int countComponents(int n, int[][] edges) {
        var visited = new HashSet<Integer>();
        var adjList = createAdjacencyList(edges);
        int count =0;
        for(int node=0; node<n; node++) {
            if(visited.contains(node)) continue;
            count++;
            dfs(node, adjList, visited);
        }
        return count;
    }

    Map<Integer, List<Integer>> createAdjacencyList(int[][]edges) {
        var adjList = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<edges.length; i++) {
            adjList.computeIfAbsent(edges[i][0], k-> new ArrayList<Integer>())
                .add(edges[i][1]);
            adjList.computeIfAbsent(edges[i][1], k-> new ArrayList<Integer>())
                .add(edges[i][0]);
        }
        return adjList;
    }

    void dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        var neighbours = adjList.get(node);
        if(neighbours == null || neighbours.isEmpty())
            return;

        visited.add(node);

        for(int neighbour: neighbours) {
            if(visited.contains(neighbour)) continue;
            dfs(neighbour, adjList, visited);
        }
    }
}
