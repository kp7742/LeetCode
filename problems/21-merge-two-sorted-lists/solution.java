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
        ListNode merged = new ListNode(); //Merged head
        ListNode temp = merged; //Temp for traversal
        
        //Merge lists
        while(list1 != null || list2 != null){
            if(list2 == null || (list1 != null && list1.val <= list2.val)){
                temp.next = new ListNode(list1.val);
                
                temp = temp.next;
                list1 = list1.next;
            } else if(list1 == null || (list2 != null && list1.val > list2.val)) {
                temp.next = new ListNode(list2.val);
                
                temp = temp.next;
                list2 = list2.next;
            }
        }
        
        return merged.next; //Remove dummy start node
    }
}