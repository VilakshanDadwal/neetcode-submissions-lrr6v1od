// Revision
class WordDictionary {
    private TrieNode root;

    class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        private boolean isWord = false; 
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var node = root;
        for(char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k-> new TrieNode());
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(0, word, root);
    }
    private boolean search(int i, String word, TrieNode node) {
        if(i==word.length()) return node.isWord;
        var currentChar = word.charAt(i);
        if(currentChar == '.') {
            for(char c: node.children.keySet()) {
                if(search(i+1, word, node.children.get(c)))
                    return true;
            }
        } else if(node.children.containsKey(currentChar)) {
            return search(i+1, word, node.children.get(currentChar));
        } else {
            return false;
        }
        return false;
    }
}
