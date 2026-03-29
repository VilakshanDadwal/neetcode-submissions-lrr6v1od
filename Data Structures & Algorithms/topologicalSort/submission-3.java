class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        var adjList = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        var indegree = new int[n];
        for(int edge[]: edges) {
            adjList.get(edge[0]).add(edge[1]);   
            indegree[edge[1]]++;     
        }

        //Add all nodes with indegree 0;
        var queue = new LinkedList<Integer>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        // BFS
        var result = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            var node = queue.poll();
            // add to result, as no pre-req for this node.
            result.add(node);
            for(int neighbour : adjList.get(node)) {
                indegree[neighbour]--;
                // If any neigbour pre requisites done, add to queue.   
                if(indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        if(result.size() != n) return new ArrayList<Integer>();
        return result;
    }
}
