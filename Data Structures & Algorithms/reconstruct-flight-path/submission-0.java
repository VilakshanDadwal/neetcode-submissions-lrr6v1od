class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        var adjList = new HashMap<String, List<String>>();
        var result = new ArrayList<String>();
        createAdjacencyList(tickets, adjList);
        result.add("JFK");
        // If all tickets consumed itinerary found.
        return dfs("JFK", adjList, tickets, result) ? result : new ArrayList<String>();
    }

    private void createAdjacencyList(List<List<String>> tickets, Map<String, List<String>> adjList) {
        for(List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new ArrayList<String>());
        }
        // Sorting by destination is enough because src does not need to be sorted 
        // What matters is the for a given source, the destinations need to be sorted
        // so that paths that are lexicographically sorted are visited first.
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket: tickets) {
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }
    }
    private boolean dfs(String src, Map<String, List<String>> adjList, List<List<String>> tickets, List<String> result) {
        // If number of tickets = number of flights consumed, then valid path found.
        if(result.size() - 1 == tickets.size()) return true;
        
        // If no path forward for a given source, and the above condition is not met, it means all tickets not consumed and cant move forward alogn this path.
        if(!adjList.containsKey(src)) return false;

        // Use temp list , becasue cannot modify the original list while iterating it.
        var destinations = new ArrayList<String>(adjList.get(src));
        for(int i=0; i<destinations.size(); i++) {
            var dest = destinations.get(i);
            adjList.get(src).remove(i);
            result.add(dest);
            if(dfs(dest, adjList, tickets, result)) return true;
            // If all tickets not consumed along this path, add the dest back to adjList while backtracking.
            // Also remove the dest from the result while backtracking.
            adjList.get(src).add(i, dest);
            result.remove(result.size()-1);
        }
        // If no valid path found return false
        return false;
    }
}
