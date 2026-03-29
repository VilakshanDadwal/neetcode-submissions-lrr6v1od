// DFS Optimal solution
class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    int cycleStart;
    public int[] findRedundantConnection(int[][] edges) {
        int numNodes = edges.length;
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k-> new ArrayList<Integer>())
                .add(edge[1]);
            adjList.computeIfAbsent(edge[1], k-> new ArrayList<Integer>())
                .add(edge[0]);  
        }
        var visited = new HashSet<Integer>();
        var cycleNodes = new HashSet<Integer>();
         // Initially we dont know from where cycle starts, so giving value which is not a node value.
        cycleStart = -1;
        cyclePresent(1, -1, cycleNodes, visited); // nodes start from 1 in this question.
        // starting from back because need to find last added edge that creates cycle.
        for(int i =edges.length-1; i>=0; i--) {
            if(cycleNodes.contains(edges[i][0]) && cycleNodes.contains(edges[i][1]))
                return new int[]{edges[i][0], edges[i][1]};
        }
        return new int[]{};
    }

    boolean cyclePresent(int node, int previous, Set<Integer> cycleNodes, Set<Integer> visited) {
        if(visited.contains(node)) {
            cycleStart = node;
            return true;
        }
        visited.add(node);
        if(!adjList.containsKey(node) || adjList.get(node).isEmpty()) return false;

        for(int neighbour: adjList.get(node)) {
            if(neighbour == previous) continue;
            if(cyclePresent(neighbour, node, cycleNodes, visited)){
                // while backtracking only add the nodes to cycle if we are within the cycle.
                // cycleStart = -1 signifies if we are within the cycle or not.
                if(cycleStart!=-1) cycleNodes.add(node);
                // Needed because while backtracking, nodes not in cycle will also be traversed.
                // Once cycle start has been reached dont need to add the other nodes up the path.
                if(node == cycleStart) cycleStart=-1;
                return true;
            }
        }
        return false;
    }

}
