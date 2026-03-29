// Revision
class FileSystem {

    TrieNode root;

    public FileSystem() {
        root = new TrieNode(0);
    }
    
    public boolean createPath(String path, int value) {
        var dirs = path.split("/");
        var node = root;
        for(int i=0; i<dirs.length-1; i++) {
            if(dirs[i].equals("")) continue;
            if(!node.children.containsKey(dirs[i])) return false;
            node = node.children.get(dirs[i]);
        }

        if(node.children.containsKey(dirs[dirs.length-1])
            && node.children.get(dirs[dirs.length-1]).value !=0)
            return false;
        
        node.children.put(dirs[dirs.length-1], new TrieNode(value));
        return true;

    }
    
    public int get(String path) {
        var dirs = path.split("/");
        var node = root;
        for(String dir: dirs) {
            if(dir.equals("")) continue;
            if(!node.children.containsKey(dir)) return -1;
            node = node.children.get(dir);
        }
        return node.value == 0 ? -1 : node.value;
    }

    class TrieNode {
        int value;
        Map<String, TrieNode> children = new HashMap();
        TrieNode(int value) {
            this.value = value;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
