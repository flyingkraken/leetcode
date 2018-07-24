/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    Integer out;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return out;
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty()){
            return false;
        }else{
            if(!stack.peek().hasNext()){// next is null
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }
            }

            while(stack.peek().hasNext()){
                NestedInteger tmp = stack.peek().next();
                if(tmp.isInteger()){// integer
                    out = tmp.getInteger();
                    //if(!stack.peek().hasNext()){
                     //   stack.pop();
                    //}
                    return true;
                }
                else{// nestedList
                    stack.push(tmp.getList().iterator());
                }
            }
            
            if(stack.isEmpty()){
                return false;
            }
            return true;
                 
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
