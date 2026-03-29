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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {   
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        var head = list1;
        if(list2.val < list1.val) {
            head = list2;
            list2 = list2.next;
        } else {
            list1= list1.next;
        }
        var resultList = head;

        while(list1 !=null && list2!=null) {
            if(list1.val < list2.val) {
                resultList.next = list1;
                list1 = list1.next;
            } else {
                resultList.next = list2;
                list2 = list2.next;
            }
            resultList = resultList.next;
        }

        // If any of the lists has reached its end.
        // Find the list which still has elements and use the pointer of that to attach remaining list.
        if(list1!=null) {
            resultList.next = list1;
        } else {
            resultList.next = list2;
        }

        return head;
    }
}