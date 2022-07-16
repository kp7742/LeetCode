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
        int carry = 0;
        ListNode answer = new ListNode(), curr = answer;
        while(l1 != null || l2 != null || carry != 0){
            //Do digits sum
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            
            //Find next carry
            carry = sum / 10;
            sum %= 10;
            
            //Add to answer
            curr.next = new ListNode(sum);
            
            //Move to next node
            curr = curr.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return answer.next;
    }
}