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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var dummy = new ListNode();
        var current = dummy;

        int carry =0;
        while(l1!=null || l2!=null || carry !=0) {
            var val1 = l1!=null ? l1.val : 0;
            var val2 = l2!=null ? l2.val : 0;
            
            // When end of both lists reached, carry can be 1. 
            // so sumOfDigits becomes carry as val1 and val2 will be null.
            // In this case, carry is added as new node.
            var sumOfDigits = val1 + val2 + carry;
            carry = sumOfDigits/10;
            var newNodeVal = sumOfDigits % 10;

            current.next = new ListNode(newNodeVal);
            current = current.next;

            l1 = l1!=null ? l1.next :null;
            l2 = l2!=null ? l2.next : null;
        }
        return dummy.next;
    }
}
