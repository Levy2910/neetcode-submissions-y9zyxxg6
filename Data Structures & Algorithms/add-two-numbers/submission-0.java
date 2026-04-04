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
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int carry = 0;
        int digit = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0){
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            digit = sum % 10;
            carry = sum/10;

            ListNode newNode = new ListNode(digit);
            dummy.next = newNode;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        return res.next;
    }
}
