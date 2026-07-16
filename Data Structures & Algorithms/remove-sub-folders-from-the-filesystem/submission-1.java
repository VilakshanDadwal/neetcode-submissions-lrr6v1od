// Sorting + Trie approach.
class Solution {
    class TrieNode {
        private Map<String, TrieNode> children = new HashMap<String, TrieNode>();
        private boolean isFolder = false;
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        var root = new TrieNode();
        var result = new ArrayList<String>();
        for(String path: folder) {
            var parts = path.split("/");
            var current = root;
            var isSubFolder = false;
            
            for(int i=1; i<parts.length; i++) {
                var part = parts[i];
                current = current.children.computeIfAbsent(part, k-> new TrieNode());
                
                if(!current.isFolder) continue;
                
                isSubFolder = true;
                break;
            }
            if(!isSubFolder) {
                result.add(path);
                current.isFolder = true;
            }
        }
        return result;
    }
}