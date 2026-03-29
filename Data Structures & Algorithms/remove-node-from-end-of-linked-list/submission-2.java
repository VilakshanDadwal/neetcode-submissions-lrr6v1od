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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        var current = head;
        int count=0;
        while(current!=null) {
            count++;
            current = current.next;
        }
        var length = count;


        // Edge case , if kth node is head.
        if(length == k) 
            return head.next;

        current = head;
        count=1;
        while(count < length-k) {
            current = current.next;
            count++;
        }
        current.next = current.next.next;
        return head;
    }
}
