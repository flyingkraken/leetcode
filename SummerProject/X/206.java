/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode unfinished = head.next;
        
        head.next = null;
        ListNode finished = head;
        while(unfinished!=null){
            ListNode tmp = unfinished;
            unfinished = unfinished.next;
            tmp.next = finished;
            finished = tmp;
        }
        return finished;
    }
}
