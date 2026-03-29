// Revision
class LRUCache {
    Map<Integer, Node> cache;
    int size;
    Node head; // Least recent
    Node tail; // Most recent

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        size = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        var node = cache.get(key);
        // Make node the tail node.
        removeNode(node);
        insertAtTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // Update or insert value
        Node node = null;
        if(cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            removeNode(node);
        }
        node = new Node(key, value);
        cache.put(key, node);
        // Make Node the tail node
        insertAtTail(node);
        // REmove head if size is reached
        if(cache.size() > size) {   
            var prevHead = this.head.next;
            removeNode(prevHead);
            cache.remove(prevHead.key); // This is why need to store the key in the node.
        }
        
    }

    void removeNode(Node node) {
        var prevNode = node.prev;
        var nextNode = node.next;
        if(prevNode != null) prevNode.next = nextNode;
        if(nextNode != null) nextNode.prev = prevNode;
    }

    void insertAtTail(Node node) {
         var tailPrev = this.tail.prev;
         if(tailPrev !=null) tailPrev.next = node;
         this.tail.prev = node;
         node.prev = tailPrev;
         node.next = this.tail;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
