/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        temp = newhead;
        for(int i=0;i<len-n;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        
        //return head;//WRONG!! when list's length==1, n==1, then no operation is performed on "head", just newhead.next point to null(skip "head")
        return newhead.next;
    }
}