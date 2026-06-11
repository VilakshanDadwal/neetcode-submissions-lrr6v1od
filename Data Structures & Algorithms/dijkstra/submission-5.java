class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        var result = new HashMap<Integer, Integer>();
        var adjList = new HashMap<Integer, List<int[]>>();
        var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        for(int i=0; i<n; i++) {
            adjList.put(i, new ArrayList<int[]>());
            result.put(i, -1);
        }

        for(List<Integer> edge: edges) {
            var source = edge.get(0);
            var dest = edge.get(1);
            var weight = edge.get(2);
            adjList.get(source).add(new int[]{dest, weight});
        }
        minHeap.add(new int[]{src, 0});

        while(!minHeap.isEmpty()) {
            var node = minHeap.poll();
            if(result.get(node[0]) != -1) continue;

            result.put(node[0], node[1]);
            for(int[] neighbour : adjList.get(node[0])) {
                var distFromSource = node[1] + neighbour[1];
                var currentNode = neighbour[0];
                if(result.get(currentNode) == -1)
                    minHeap.add(new int[]{currentNode, distFromSource});
            }
        }
        return result;
    }  
}
