/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newhead = new ListNode(-1);     
        ListNode p = head;
        newhead.next = p;
        ListNode pre = newhead;

        
        //if(p.next!=null) tmp = p.next.next;
        //tmp = p.next;
        while(p!=null &&p.next!=null){
            pre.next = p.next;
            p.next = p.next.next;
            pre.next.next = p;
            
            pre = p;
            p = p.next;
        }
        
        return newhead.next;
        
    }
}