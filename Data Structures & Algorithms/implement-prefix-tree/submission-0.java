class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
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
        var node = root;
        for(char c: word.toCharArray()) {
            if(!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        var node = root;
        for(char c: prefix.toCharArray()) {
            if(!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
    static class TrieNode {
        boolean isEndOfWord = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
