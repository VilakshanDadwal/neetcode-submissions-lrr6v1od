class Solution {
    private Map<Character, Set<Character>> adjList = new HashMap();
    public String foreignDictionary(String[] words) {
        
        // Create Adjacency List by comparing alternate words.
        // Note - no need to create edges first. 
        // When chars dont match, edge is found, its direclty added to adjacency list.
        
        for(String word: words) {
            for(char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }

        // Compare words and create list.
        for(int i=0; i < words.length-1; i++) {
            var w1 = words[i];
            var w2 = words[i+1];
            var smallerLength = Math.min(w1.length(), w2.length());
            
            // Invalid list of words - This will happen if the given order of words 
            // is not lexicographically sorted.
            if(w1.length() > w2.length() &&
                w1.substring(0, smallerLength).equals(w2.substring(0, smallerLength)))
                    return "";

            // Comparing words and add the first non equal characters as an edge to adjacency list.
            for(int j=0; j < smallerLength; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adjList.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }

        }

        var visited = new HashSet<Character>();
        var path = new HashSet<Character>();
        var result = new ArrayList<Character>();

        for(char c : adjList.keySet()) {
            // If cycle in dependencies, invalid words given.
            if(dfs(c, visited, path, result)) return "";
        }

        Collections.reverse(result);
        var sb = new StringBuilder();
        for(char c: result) 
            sb.append(c);
        return sb.toString();
    }

    private boolean dfs(char c, Set<Character> visited, Set<Character>  path, List<Character> result) {
        if(path.contains(c)) return true; // cycle found.
        if(visited.contains(c)) return false;
        
        path.add(c);
        visited.add(c);
        for(char neighbour : adjList.get(c)) {
            if(dfs(neighbour, visited, path, result)) return true; // Cycle found
        }
        path.remove(c);
        result.add(c);
        return false;
    }
}