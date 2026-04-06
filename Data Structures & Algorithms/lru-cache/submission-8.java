
// Revision
class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        var node = map.get(key);
        remove(node);
        insertAsHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else { 
            if(map.size() == this.capacity) {
               map.remove(tail.prev.key);
               remove(tail.prev);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        insertAsHead(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAsHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
