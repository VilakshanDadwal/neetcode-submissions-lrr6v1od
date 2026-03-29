/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // count total nodes
        var current = head;
        var size =0;
        while(current !=null) {
            size++;
            current = current.next;
        }

        // Need these many steps to reach one node before the node to remove.
        var steps = size - n;
        // If head is the node to remove , return the next of head.
        if(steps == 0) return head.next;
        
        var node = head;
        while(node!=null && steps > 1) {
            node = node.next;
            steps--;
        }


        // Remove node
        node.next = node.next.next;
        return head;
    }
}
