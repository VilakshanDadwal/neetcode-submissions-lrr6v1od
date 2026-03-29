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


// Single pass solution
class Solution {
    public Node copyRandomList(Node head) {
        var map = new HashMap<Node, Node>();
        map.put(null, null);

        var current = head;
        while(current!=null) {
            var newNode = map.computeIfAbsent(current, c -> new Node(c.val));
            
            newNode.next = current.next == null 
            ? null
            : map.computeIfAbsent(current.next, c -> new Node(c.val));

            newNode.random = current.random == null 
            ? null
            : map.computeIfAbsent(current.random, c -> new Node(c.val));
            
            current = current.next;
        }
        return map.get(head);
    }
}
