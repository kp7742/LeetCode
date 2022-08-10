/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        //Floyd's Cycle Detection
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            //Two pointer meet so cycle detected
            if(slow == fast){
                //Find start of the cycle
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return fast;
            }
        }
        
        //No cycle was there
        return null;
    }
}