class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        var adjList = new HashMap<Integer, List<Integer>>();
        for(int i=0 ; i<n; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        var visited = new HashMap<Integer, Boolean>();
        var ancestor = new HashSet<Integer>();

        return canReachDestination(source, destination, adjList, visited, ancestor);
    }

    boolean canReachDestination(int source, int destination, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visited, Set<Integer> ancestor) {
        if(ancestor.contains(source)) return false;
        if(visited.containsKey(source)) return visited.get(source);

        // This is a given condition in the question, that if a node has no neihgbours, then it has to be the destination.
        if(adjList.get(source).isEmpty()) return source == destination;

        ancestor.add(source);

        for(int neighbour : adjList.get(source)) {
            if(!canReachDestination(neighbour, destination, adjList, visited, ancestor)) {
                ancestor.remove(source);
                visited.put(source, false);
                return false;
            }
        }
        ancestor.remove(source);
        visited.put(source, true);
        return true;
    }
}
