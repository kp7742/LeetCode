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
        ListNode dummy = new ListNode();
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;

        //Move fast till nth node from start
        for(int i=0; i<=n; i++) {
            fast = fast.next;
        }
        
        //It will place slow just before nth node from end
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        //Skip nth node
        slow.next = slow.next.next;
        return dummy.next;
    }
}