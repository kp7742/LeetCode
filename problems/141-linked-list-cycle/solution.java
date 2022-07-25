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
    public boolean hasCycle(ListNode slow) {
        ListNode fast = slow;
        
        //Floyd's Cycle Detection
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            //Two pointer meet so cycle detected
            if(slow == fast)
                return true;
        }
        
        //No cycle was there
        return false;
    }
}