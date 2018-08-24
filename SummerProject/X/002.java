/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val+l2.val)%10);
        ListNode n = new ListNode(0);
        n = result;
        int carry = (l1.val+l2.val)/10;
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1!=null || l2!=null || carry!=0){
            
            int sum=0;
            
            if(l1==null && l2!=null){
                sum = l2.val + carry;        
            }
            else if(l1!=null && l2==null){
                sum = l1.val + carry;
            }
            else if(l1==null && l2==null){
                sum = carry;
            }
            else{
                sum = l1.val + l2.val + carry;
            }
            
            ListNode tmp = new ListNode(sum%10);
            carry = sum/10;
            n.next = tmp;
            n = tmp;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        
        return result;
    }
}
