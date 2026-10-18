class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var adjList = new HashMap<Integer, List<int[]>>();
        for(int i=1; i<=n; i++) {
            adjList.put(i, new ArrayList<int[]>());
        }

        for(int[] time: times) {
            adjList.get(time[0])
                .add(new int[]{time[1], time[2]});
        }

        var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[]{k, 0});
        var visited = new boolean[n+1];
        var noVisited = 0;
        var minTime = Integer.MIN_VALUE;
        var currentDistanceFromSource = 0; 
        while(!minHeap.isEmpty() && noVisited != n) {
            var current = minHeap.poll();
            var nodeId = current[0];
            var nodeDistanceSource = current[1];
            if(visited[nodeId]) continue;
            minTime = Math.max(minTime, nodeDistanceSource);
            for(var child : adjList.get(nodeId)) {
                if(visited[child[0]]) continue;
                minHeap.add(new int[] {child[0], child[1] + nodeDistanceSource});
            }
            visited[nodeId] = true;
            noVisited++;
        }
        return noVisited == n ? minTime : -1;
    }
}
