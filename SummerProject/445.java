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
        int len1 = 0, len2 = 0;
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        while(iter1!=null){
            len1++;
            iter1 = iter1.next;
        }
        
        while(iter2!=null){
            len2++;
            iter2 = iter2.next;
        }
        
        int len = Math.max(len1,len2);
        int[] a1 = new int[len];
        int[] a2 = new int[len];
        int[] res = new int[len+1];
        for(int i=0;i<len1;i++){
            a1[len1-1-i] = l1.val;
            l1 = l1.next;
        }

        for(int i=0;i<len2;i++){
            a2[len2-1-i] = l2.val;
            l2 = l2.next;
        }

        for(int i=0;i<res.length-1;i++){
            int sum = res[i] + a1[i] + a2[i];
            res[i] = sum%10;
            res[i+1] += sum/10;
        }
        
        //Construct a linkedlist as output
        ListNode result = new ListNode(res[len]);
        ListNode iter = result;
        if(res[len]!=0){
            iter.val = res[len];
            ListNode tmp = new ListNode(res[len-1]);
            iter.next = tmp;
            iter = iter.next;
        }
        else{
            iter.val = res[len-1];
        }
        for(int i=len-2;i>=0;i--){
            ListNode tmp = new ListNode(res[i]);
            iter.next = tmp;
            iter = iter.next;
        }
        
        return result;
    }
}
