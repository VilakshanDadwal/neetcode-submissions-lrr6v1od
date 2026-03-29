class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();
        // Initialised as dummy nodes.
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            var node = cache.get(key);
            removeFromCurrentPosition(node);
            insertAsHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            removeFromCurrentPosition(cache.get(key));
        }
        var newNode = new Node(key, value);
        cache.put(key, newNode);
        insertAsHead(newNode);

        // If capacity limit breached
        if(cache.size() > capacity) {
            // Because we are using a dummy node.
            var lruNode = this.tail.prev;
            removeFromCurrentPosition(lruNode);
            // This is why need to save key in node.
            cache.remove(lruNode.key);
        }
    }
    private void removeFromCurrentPosition(Node node) {
        var prev = node.prev;
        var next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertAsHead(Node node) {
        var next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        next.prev = node;
        node.next = next;
    }


    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
