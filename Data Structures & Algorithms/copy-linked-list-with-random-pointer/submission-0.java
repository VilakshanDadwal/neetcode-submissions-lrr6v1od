/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


// Two pass solution
class Solution {
    public Node copyRandomList(Node head) {
        var map = new HashMap<Node, Node>();
        map.put(null, null);

        var current = head;
        while(current!=null) {
            var newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }

        current = head;
        while(current!=null) {
            var newNode = map.get(current);
            // Need to fetch from map, because deepCopy is needed.
            // cant point to nodes in original list.
            newNode.random = map.get(current.random);
            newNode.next = map.get(current.next);
            current = current.next;
        }
        return map.get(head);
    }
}
