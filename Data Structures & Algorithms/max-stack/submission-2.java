// Tree Map + DDL - ChatGPT code.
class MaxStack {

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    TreeMap<Integer, List<Node>> map;
    Node head;
    Node tail;

    public MaxStack() {
        map = new TreeMap<>();

        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
    }

    // add node to DLL
    private void add(Node node) {
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    // remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void push(int x) {
        Node node = new Node(x);

        add(node);

        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node node = tail.prev;

        remove(node);

        List<Node> list = map.get(node.val);
        list.remove(list.size() - 1);

        if (list.isEmpty())
            map.remove(node.val);

        return node.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {

        int max = map.lastKey();
        List<Node> list = map.get(max);

        Node node = list.remove(list.size() - 1);

        if (list.isEmpty())
            map.remove(max);

        remove(node);

        return max;
    }
}