// This is not using pattern solution given by neetcode.
// This builds adjacency list of words which differ by 1 char.
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // If endWord is not present, no transformation is possible.
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // Add beginWord to the list to treat it like a normal node in the graph
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        int n = wordList.size();
        int wordLength = beginWord.length();
        
        // Map each word to an index
        Map<String, Integer> wordToIndex = buildWordIndexMap(wordList);

        // Build adjacency list graph
        List<List<Integer>> adj = buildGraph(wordList, wordLength);

        // BFS to find shortest path from beginWord to endWord
        return performBFS(beginWord, endWord, wordList, wordToIndex, adj);
    }

    // Build adjacency list connecting words differing by exactly 1 letter
    private List<List<Integer>> buildGraph(List<String> wordList, int wordLength) {
        int n = wordList.size();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // O(n^2 * wordLength) preprocessing
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (differsByOneLetter(wordList.get(i), wordList.get(j), wordLength)) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        return adj;
    }

    // ----------------------------------------------------------------------
    // Standard BFS on the adjacency graph
    private int performBFS(
            String beginWord,
            String endWord,
            List<String> wordList,
            Map<String, Integer> wordToIndex,
            List<List<Integer>> adj) {

        int start = wordToIndex.get(beginWord);
        int end = wordToIndex.get(endWord);
        int wordLength = beginWord.length();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int steps = 1; // beginWord is step 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : adj.get(curr)) {
                    if (neighbor == end) {
                        return steps;
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    // Build word -> index map
    private Map<String, Integer> buildWordIndexMap(List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), i);
        }
        return map;
    }
    // Check if two words differ by exactly one character
    private boolean differsByOneLetter(String a, String b, int m) {
        int diff = 0;
        for (int i = 0; i < m; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}