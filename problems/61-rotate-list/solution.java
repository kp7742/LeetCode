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
    public ListNode rotateRight(ListNode head, int k) {
        //If 0 or 1 node there
        if(head == null || head.next == null || k == 0)
            return head;
        
        ListNode currNode = head;
        
        //Find length of LinkedList
        int len = 1;
        for(;currNode.next != null; len++)
            currNode = currNode.next;
        
        //Get k into range
        k %= len;
        
        //Join last node with head
        currNode.next = head;
        
        //Go till our split point
        for (len -= k; len > 1; len--)
            head = head.next;
        
        //Set split point node our new head
        currNode = head.next;
        
        //Remove connection with previous node
        head.next = null;
            
        return currNode;
    }
}