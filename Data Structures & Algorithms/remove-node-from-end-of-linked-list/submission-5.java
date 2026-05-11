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
        var current = head;
        var count=0;
        while(current!=null) {
            current = current.next;
            count++;
        }

        if(count == n) {
           return head.next;
        }
        var k = 1;
        var node = head;

        while(node!=null && k < count-n) {
            node = node.next;
            k++;
        }
        node.next = node.next.next;
        return head;
    }
}
