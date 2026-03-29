class WordDictionary {
    private TrieNode root;
    
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
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNode node) {
        if(i==word.length())
            return node.isEndOfWord;

        var currentChar = word.charAt(i);
        if(currentChar == '.') {
            for(char skipChar :node.children.keySet()) {
                if(search(word, i+1, node.children.get(skipChar)))
                    return true;
            }
        } else {
            if(!node.children.containsKey(currentChar)) 
                return false;
            return search(word, i+1, node.children.get(currentChar));
        }
        return false;
    }

    class TrieNode {
        private boolean isEndOfWord = false;
        private Map<Character, TrieNode> children = new HashMap();
    }
}
