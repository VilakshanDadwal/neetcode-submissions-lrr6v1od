class WordDictionary {
    TrieNode root; 
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var node = this.root;
        for(char c: word.toCharArray()) {
            if(!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int idx, TrieNode node) {
        var current = node;
        for(int i=idx; i<word.length(); i++) {
            var c = word.charAt(i);
            if(c =='.') {
                for(Map.Entry<Character, TrieNode> childEntry : current.children.entrySet()) {
                    if(search(word, i+1, childEntry.getValue()))
                        return true;
                }
                return false;
            } else {
                if(!current.children.containsKey(c)) return false;
                current = current.children.get(c);
            }
        }
        return current.isEndOfWord;
    }

    static class TrieNode {
        boolean isEndOfWord = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
