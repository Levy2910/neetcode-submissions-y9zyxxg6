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
        // divide the list in half
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondList = slow.next;
        slow.next = null;
        ListNode firstList = head;
        ListNode updatedSecondList = reverseList(secondList);

        mergeTwoLists(firstList, updatedSecondList);
    }
    private void mergeTwoLists(ListNode firstList, ListNode secondList){
        ListNode result = new ListNode();
        ListNode dummy = result;
        boolean addFirst = true;
        while (firstList != null && secondList != null){
            if (addFirst){
                dummy.next = firstList;
                dummy = dummy.next;
                firstList = firstList.next;
                addFirst = false;
            }else{
                dummy.next = secondList;
                dummy = dummy.next;
                secondList = secondList.next;
                addFirst = true;
            }
        }
        if (firstList != null) dummy.next = firstList;
        if (secondList != null) dummy.next = secondList;

    }
    private ListNode reverseList(ListNode secondList){
        ListNode prev = null;
        ListNode curr = secondList;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
