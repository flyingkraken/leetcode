/*
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int len = tasks.length;
        int max1=0;
        int max2=0;
        
        for(int i=0;i<len;i++){
            count[tasks[i]-65]++;
        }
        
        for(int i=0;i<26;i++){
            if(count[i]>=max1){
                max2 = max1;
                max1 = count[i];
            }
        }
        
        if(n>1){
            if(max1 == max2){//this is the problem. I only considered the number of two kinds of tasks to be equal, actually there can be   more than two kinds of those to be equal. To make it right, every kind of task should be checked as is shown in the submitted version below
                return Math.max((max1-1)*(n-1), len-2*max1) + 2*max1;
            }
            else{
                return Math.max((max1-1)*n, len-max1) + max1;
            }
        }
        else{
            return Math.max((max1-1)*n, len-max1) + max1;
        }
    }
}
*/
/*Above is a wrong answer*/


public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
