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
        var stack1 = new Stack<Integer>();
        var stack2 = new Stack<Integer>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        var carry = 0;
        ListNode head = null;

        while(!stack1.isEmpty() || !stack2.isEmpty()  || carry > 0) {
            var num1 = stack1.isEmpty() ? 0 : stack1.pop();
            var num2 = stack2.isEmpty() ? 0 : stack2.pop();
            var total = num1 + num2 + carry;
            carry = total/10;
            var node = new ListNode(total%10);
            node.next = head;
            head = node;
        }

        return head;
    }
}