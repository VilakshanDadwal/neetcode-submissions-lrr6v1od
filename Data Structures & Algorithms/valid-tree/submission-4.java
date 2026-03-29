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

        // If cycle present then its invalid tree.
        if(!validTree(0, adjList, visited, previous)) return false;
        return visited.size() == n;
    }

    boolean validTree(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited, int previous) {
        if(visited.contains(node)) return false;
        visited.add(node);

        var neighbours = adjList.get(node);
        // This is needed becasue we are not creating every node when creating adjacency list
        // we are creating only those which have edges. so a node may not be present in the adjacency list.
        if(neighbours == null || neighbours.isEmpty()) return true;

        for(int neighbour: neighbours) {
            if(neighbour == previous) continue; // Ignore, if neighbour is same as previous
            if(!validTree(neighbour, adjList, visited, node)) // If cycle present exit.
                return false;
        }
        return true;
    }
}
