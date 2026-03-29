class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree should have n-1 edges.
        if(edges.length != n-1) return false;

        var visited = new HashSet<Integer>();
        int previous = -1;
        var adjList = new HashMap<Integer, List<Integer>>();
        for(int[] edge: edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<Integer>())
                .add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<Integer>())
                .add(edge[0]);
        }

        validTree(0, adjList, visited, previous);
        return visited.size() == n;
    }

    boolean validTree(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited, int previous) {
        if(visited.contains(node)) return false;
        visited.add(node);

        var neighbours = adjList.get(node);
        if(neighbours == null || neighbours.isEmpty()) return true;

        for(int neighbour: neighbours) {
            if(neighbour == previous) continue;
            if(!validTree(neighbour, adjList, visited, node))
                return false;
        }
        return true;
    }
}
