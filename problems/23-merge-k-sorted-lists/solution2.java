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
        
        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i < lists.length - interval; i += interval * 2)
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            interval *= 2;
        }
        
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode curr = merged;
        while(list1 != null || list2 != null){
            if(list2 == null || (list1 != null && list1.val <= list2.val)){
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else if(list1 == null || (list2 != null && list1.val > list2.val)){
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        return merged.next;
    }
}