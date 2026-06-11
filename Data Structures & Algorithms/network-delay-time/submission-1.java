class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        var visited = new HashSet<Integer>();
        var minTime = Integer.MIN_VALUE;

        var adjList = new HashMap<Integer, List<int[]>>();
        for(int i=1; i<=n; i++) {
            adjList.put(i, new ArrayList<int[]>());
        }

        for(int[] time: times) {
            var src = time[0];
            var dest = time[1];
            var timeTaken = time[2];
            adjList.get(src).add(new int[]{dest, timeTaken});
        }

        minHeap.add(new int[]{k, 0});

        while(!minHeap.isEmpty()) {
            var node = minHeap.poll();
            var timeNode = node[1];
            var nodeLabel = node[0];
            
            if(visited.contains(nodeLabel)) continue;
            
            visited.add(nodeLabel);
            minTime = Math.max(timeNode, minTime);
            
            for(int[] neighbour: adjList.get(nodeLabel)) {
                if(!visited.contains(neighbour[0])) {
                    minHeap.add(new int[]{neighbour[0], timeNode + neighbour[1]});
                }
            }
        }
        return visited.size() != n ? -1 : minTime;
    }
}
