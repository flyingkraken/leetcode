/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


/* Merge two sorted lists
** use node "p" to rearrange the list
** slow efficiency
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newhead = new ListNode(-1);
        ListNode p = newhead;
        
        while(p1!=null || p2!=null){
            if(p1==null || (p2!=null && p1.val>p2.val)){
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p = p1;
                p1 = p1.next;
            }
        }
        
        return newhead.next;
        
    }
}

/* Insert nodes from L2 into L1
** high efficiency
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newhead = new ListNode(-1);
        newhead.next = l1;
        ListNode prep1 = newhead;
        
        while(p1!=null){
            while(p2!=null){
                if(p2.val<=p1.val){
                    ListNode temp2 = p2.next;
                    prep1.next = p2;
                    p2.next = p1;
                    prep1 = p2;
                    //System.out.println(prep1.next.val+" and "+p1.val);
                    p2 = temp2;
                }else{
                    
                    break;
                }
                
            }
            prep1 = p1;
            p1 = p1.next;
        }
        while(p2!=null){
            ListNode tmp = p2.next;
            prep1.next = p2;
            prep1 = p2;
            p2 = tmp;
        }
        return newhead.next;
    }
}


/* recursive solution
** put the smaller node ahead, then do the same thing to the rest of the two lists 
** higher efficiency, why??
*/


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
}