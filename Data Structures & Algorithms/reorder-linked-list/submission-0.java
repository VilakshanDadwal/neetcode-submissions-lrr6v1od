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
    public void reorderList(ListNode head) {
        // Find Middle
        var slow = head;
        // Need to start at head.next to find the left middle in an even length list.
        var fast = head.next;
        var middle = makeSlowReachMiddle(slow, fast);


        // Now Reverse the second half of the list. 
        var secondHead = reverseSecondHalf(middle.next);
        // Break the list 
        middle.next = null;

        // Merge first and second half as per requirement of question.
        mergeList(head, secondHead);
    }

    ListNode makeSlowReachMiddle(ListNode slow, ListNode fast) {
        // Slow will be at middle when fast or fast.next reaches null.
         while(fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null;
        var current = head;
        while(current!=null) {
            var tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
    void mergeList(ListNode first, ListNode second) {
        // This is because second list will be smaller than first list , when length of original list is odd.
        // So second list will run out of elements before first.
        // For even size list, first and second would be same.
        while(second != null) {
            var tmp1 = first.next;
            var tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
