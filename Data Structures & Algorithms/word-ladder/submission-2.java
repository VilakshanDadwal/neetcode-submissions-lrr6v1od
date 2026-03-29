// BFS with pattern
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        var adjList = new HashMap<String, List<String>>();
        wordList.add(beginWord);
        // Create pattern to word adjacency List.
        // All words with same pattern need to be grouped together.
        for(String word : wordList) {
            for(int j=0; j<word.length(); j++) {
                // Exclude char at j index. endIndex in substring is exclusive.
                // Thats why starting from j+1 and not j.
                var pattern = word.substring(0,j) + "*" + word.substring(j+1);
                adjList.computeIfAbsent(pattern, k -> new ArrayList<String>())
                    .add(word);
            }
        }

        var visited = new HashSet<String>();
        var q = new LinkedList<String>();
        q.add(beginWord);

        var result = 1; // Begin word is also included in the path. Basically result is all words in the path.
        while(!q.isEmpty()) {
            var size = q.size();
            // Consider all words at a level in BFS
            for(int i=0; i < size; i++) {
                var word = q.poll();
                if(word.equals(endWord)) return result;
                // Generate pattern for every character for current word
                // For the matching words, add them to queue, if not visited.
                for(int j=0; j < word.length(); j++) {
                    var pattern = word.substring(0,j) + "*" + word.substring(j+1);
                    var matchingWords = adjList.getOrDefault(pattern, Collections.emptyList());
                    for(String match : matchingWords) {
                        if(!visited.contains(match)) {
                            q.add(match);
                            visited.add(match);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
