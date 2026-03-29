class Solution {
    public int minCostConnectPoints(int[][] points) {
        var adjList = new HashMap<Integer, List<int[]>>();
        var visited = new HashSet<Integer>();
        var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));

        var minCost = 0;

        createAdjList(adjList, points); 
        minHeap.add(new int[]{0,0});
        while(visited.size() < points.length) {
            var current = minHeap.poll();
            var cost = current[0];
            var dest = current[1];
            if(visited.contains(dest)) continue;
            visited.add(dest);
            minCost += cost;
            for(int[] neighbour : adjList.getOrDefault(dest, Collections.emptyList())) {
                var neighbourCost = neighbour[0];
                var neighbourDest = neighbour[1];
                if(!visited.contains(neighbourDest))
                    minHeap.add(new int[]{neighbourCost, neighbourDest});
            }
        }
        return minCost;
    }

    private void createAdjList(Map<Integer, List<int[]>> adjList, int[][] points) {
        // i represents the ith point in the points array.
        // Similarly for j. 
        for(int i=0; i < points.length; i++) {
            var x1 = points[i][0];
            var y1 = points[i][1];
            for(int j=i+1; j < points.length; j++) {
                var x2 = points[j][0];
                var y2 = points[j][1];
                var distance = Math.abs(x1-x2) + Math.abs(y1-y2);
                adjList.computeIfAbsent(i, k -> new ArrayList<int[]>())
                    .add(new int[]{distance, j});
                adjList.computeIfAbsent(j, k -> new ArrayList<int[]>())
                    .add(new int[]{distance, i});
            }
        }
    }
}
