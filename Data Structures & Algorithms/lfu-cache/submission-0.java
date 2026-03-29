class LFUCache {
    private int capacity;
    private int size;
    private int minFreq;
    private Map<Integer, DLLNode> cache;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        var node = cache.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity ==0) return;
        // If node present, get it and update its freq, move it to new freqList.
        if(cache.containsKey(key)) {
            var node = cache.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            // If node not present, check capacity, evict LRU node from LFU list.
            // create new Node and add it to correct Freq List, create new if not exist.
            size++;
            if(size > capacity) {
                var minFreqList = freqMap.get(this.minFreq);
                // Remove node from the list.
                // This needs to be done first before removing node from dLL because removing node changes tail of the list and that is used while removing from map.
                cache.remove(minFreqList.tail.prev.key); // this is why key is needed in the DLL Node, to remove it from map.
                // Remove the LRU node from the LFU list.
                minFreqList.remove(minFreqList.tail.prev);
                
            }
            // New node added, minFreq wiill be 1.
            minFreq = 1;
            // Craete new DLL node, then add to exsisting minFreq List or create new List
            var newNode = new DLLNode(key, value);
            var newNodeFreqList = freqMap.getOrDefault(1, new DoublyLinkedList());
            newNodeFreqList.insertAsHead(newNode);
            // Update freqList
            freqMap.put(1, newNodeFreqList);
            // Update map.
            cache.put(key, newNode);
        }
    }

    private void updateFreq(DLLNode node) {
        // Move node to new DLL 
        var freqList = freqMap.get(node.freq);
        freqList.remove(node);
        // If freq of node is minFreq and its the last element in the list, 
        // Need to update minFreq value.
        if(node.freq == this.minFreq && freqList.dllSize==0) // This is why size is needed of the list.
            minFreq++;

        // Increase usage of currentNode
        node.freq++;
        // Add node to existing list with new freq or create new list.
        var newFreqList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newFreqList.insertAsHead(node);
        // Update Map with updated list.
        freqMap.put(node.freq, newFreqList);
    }

    private class DLLNode {
        private int key;
        private int value;
        private DLLNode prev;
        private DLLNode next;
        private int freq;

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private class DoublyLinkedList {
        DLLNode head;
        DLLNode tail;
        int dllSize;

        DoublyLinkedList () {
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            this.dllSize =0;
            head.next = tail;
            tail.prev = head;
            
        }

        void insertAsHead(DLLNode node) {
            var currentHead = head.next;
            node.next = currentHead;
            node.prev = head;
            head.next = node;
            currentHead.prev = node;
            dllSize++;
        }

        void remove(DLLNode node) {
            var prev = node.prev;
            var next = node.next;
            prev.next = next;
            next.prev = prev;
            dllSize--;
        }
    } 
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */