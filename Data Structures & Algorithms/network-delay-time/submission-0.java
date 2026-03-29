class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var adjList = new HashMap<Integer, List<int[]>>();
        var visited = new HashSet<Integer>();
        // Min time taken for all nodes to get the signal
        // is the maxTime any node will take to get the signal.
        var maxTime = 0;
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, k}); // Add start node.
        
        // Create Adjacency list.
        for(int i=1; i<=n; i++) {
            adjList.put(i, new ArrayList<int[]>());
        }
        for(int[] timeInfo : times) {
            var src = timeInfo[0];
            var dest = timeInfo[1];
            var time = timeInfo[2];
            adjList.get(src).add(new int[] {dest, time});
        }

        while(!minHeap.isEmpty()) {
            var currentNode = minHeap.poll();
            var currentNodeTime = currentNode[0];
            var currentNodeLabel = currentNode[1];
            if(visited.contains(currentNodeLabel)) continue;
            visited.add(currentNodeLabel);
            // Becasue we are using Minheap, nodes will be processed in the increasing time time will reach them
            // The last node that is processed will have the total time it takes to reach all nodes.
            maxTime = currentNodeTime;
            for(int[] neighbour : adjList.get(currentNodeLabel)) {
                var neighbourLabel = neighbour[0];
                var neighbourTime = neighbour[1];
                if(!visited.contains(neighbourLabel))
                    minHeap.add(new int[]{neighbourTime + currentNodeTime, neighbourLabel});
            }
        }
        // Only if all nodes visited then all nodes are reachable.
        return visited.size()==n ? maxTime : -1;
    }
}
