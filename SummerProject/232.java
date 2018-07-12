class MyQueue {
    Stack<Integer> q ;
    Stack<Integer> dummy;
    /** Initialize your data structure here. */
    public MyQueue() {
         q = new Stack<>();
        dummy = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(q.isEmpty()){
            q.push(x);
        }
        else{
            while(!q.isEmpty()){
                dummy.push(q.pop());
            }
            q.push(x);
            while(!dummy.isEmpty()){
                q.push(dummy.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return q.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return q.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return(q.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
