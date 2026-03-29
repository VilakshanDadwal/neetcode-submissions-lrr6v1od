class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();

        // Step 1: Build Trie with ALL folders
        for (String f : folder) {
            trie.add(f);
        }

        List<String> result = new ArrayList<>();

        // Step 2: Check each folder
        for (String f : folder) {
            if (!trie.hasPrefix(f)) {
                result.add(f);
            }
        }

        return result;
    }

    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    class Trie {

        TrieNode root = new TrieNode();

        // Build Trie with all folders
        public void add(String path) {

            TrieNode curr = root;

            String[] parts = path.split("/");

            for (String part : parts) {

                if (part.isEmpty()) continue;

                curr.children.putIfAbsent(part, new TrieNode());
                curr = curr.children.get(part);
            }

            curr.isEnd = true;
        }

        // Check if this path has a prefix folder
        public boolean hasPrefix(String path) {

            TrieNode curr = root;

            String[] parts = path.split("/");

            // IMPORTANT: we stop before last folder
            for (int i = 0; i < parts.length - 1; i++) {

                if (parts[i].isEmpty()) continue;

                curr = curr.children.get(parts[i]);

                // If any prefix is already a folder → subfolder
                if (curr.isEnd) return true;
            }

            return false;
        }
    }
}