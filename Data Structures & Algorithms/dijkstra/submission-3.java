class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        var result = new HashMap<Integer, Integer>();
        var adjList = new HashMap<Integer, List<int[]>>();
        var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] {0, src});

        // Create Adjacency List
        for(int i=0; i<n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(List<Integer> edge: edges) {
            var source = edge.get(0);
            var dest = edge.get(1);
            var weight = edge.get(2);
            adjList.get(source).add(new int[]{weight, dest});
        }

        // Find shortest path.
        while(!minHeap.isEmpty()) {
            var node = minHeap.poll();
            var nodeWeight = node[0];
            var nodeLabel = node[1];
            // If already minDistance calculated, skip.
            // This is like the visited check.
            if(result.containsKey(nodeLabel)) continue;
            // The node popped from minHeap has the shortest distance.
            // Thus, can be added to result.
            result.put(nodeLabel, nodeWeight);

            for(int[] neighbour: adjList.get(nodeLabel)) {
                var neighbourWeight = neighbour[0];
                var neighbourLabel = neighbour[1];
                if(!result.containsKey(neighbourLabel))
                    minHeap.add(new int[] {nodeWeight + neighbourWeight, neighbourLabel});
            }
        }

        for (int i = 0; i < n; i++) {
            result.putIfAbsent(i, -1);
        }

        return result;
    }  
}
