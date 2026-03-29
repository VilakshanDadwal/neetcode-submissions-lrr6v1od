// Revision without dummy nodes
class LRUCache {
    Map<Integer, Node> cache;
    int size;
    Node head; // Least recent
    Node tail; // Most recent

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        var node = cache.get(key);
        // Make node the tail node, if not already tail node.
        if(node != tail) {
            removeNode(node);
            insertAtTail(node);
        }
 
        return node.value;
    }
    
    public void put(int key, int value) {
        // Existing Key
        if(cache.containsKey(key)) {
            var node = cache.get(key);
            node.value = value;
            if(node != tail) {
                removeNode(node);
                insertAtTail(node);
            }
            return;
        } 
        // New Key
        var node = new Node(key, value);
        cache.put(key, node);
        // Make Node the tail node
        insertAtTail(node);
        // REmove head if size is reached
        if(cache.size() > size) {   
            cache.remove(head.key); // This is why need to store the key in the node.
            removeNode(head);
        }
    }

    void removeNode(Node node) {
        // If node is head, update to new head.
        if(node == head) {
            head = head.next;
        }
        // If node is tail, update to new tail.
        if(node == tail) {
            tail = tail.prev;
        }
        
        // Update prev and next of current node.
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;

        /**
        if(head == null || tail == null) {
            head = null;
            tail = null;
        }
        **/
        
        // Remove pointers of current node.
        node.prev = null;
        node.next = null;
    }

    void insertAtTail(Node node) {
        if(tail == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        node.next = null;
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
