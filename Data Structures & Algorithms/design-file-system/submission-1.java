class FileSystem {
    private TrieNode root;
    
    public FileSystem() {
        root = new TrieNode();    
    }
    
    public boolean createPath(String path, int value) {
        var current = root;
        var paths = path.split("/");
        for(int i=0; i<paths.length-1; i++) {
            if(paths[i].equals("")) continue;
            if(!current.children.containsKey(paths[i]))
                return false;
            current = current.children.get(paths[i]);
        }
        // If last dir in the path exists already and has a value.
        // Important to check value, because it could be a mid directory of another path.
        if(current.children.containsKey(paths[paths.length-1])
            && current.children.get(paths[paths.length-1]).value != 0)
            return false;
        // If last dir does not exist, create and assign value
        current.children.put(paths[paths.length-1], new TrieNode());
        current.children.get(paths[paths.length-1]).value = value;
        return true;
    }
    
    public int get(String path) {
        var current = root;
        var paths = path.split("/");
        for(String dir : paths) {
            if(dir.equals("")) continue;
            if(!current.children.containsKey(dir)) return -1;
            current = current.children.get(dir);
        }
        return current.value == 0 ? -1 : current.value;
    }
    
    class TrieNode {
        private Map<String, TrieNode> children = new HashMap<>();
        private int value; 
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
