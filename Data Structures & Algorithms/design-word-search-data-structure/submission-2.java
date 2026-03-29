// Revision
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var node = root;
        for(char c : word.toCharArray()) {
            if(!node.children.containsKey(c))
                node.children.put(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(0, word, root);
    }

    private boolean search(int i, String word, TrieNode node) {
        if(i==word.length()) {
            return node.isEndOfWord;
        }
        var currentChar = word.charAt(i);
        // matching '.'
        if(currentChar == '.') {
            for(char c: node.children.keySet()) {
                if(search(i+1, word, node.children.get(c))) return true;
            }
            return false;
        }
        // Char matching
        if(!node.children.containsKey(currentChar)) 
            return false;
        
        node = node.children.get(currentChar);
        return search(i+1, word, node);
    }

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }
}
