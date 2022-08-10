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
    public ListNode mergeKLists(ListNode[] lists) {
        //No lists to merge
        if(lists.length == 0)
            return null;
        
        List<ListNode> merged = new ArrayList<ListNode>();
   
        //Store every node
        for (ListNode ls : lists) {
            while (ls != null) {
                ListNode curr = ls;
                
                merged.add(curr);
                
                ls = ls.next;
                curr.next = null;
            }
        }
        
        //Sort nodes by value
        Collections.sort(merged, (a, b) -> a.val - b.val);
        
        //Generate merged list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (ListNode node : merged) {
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}