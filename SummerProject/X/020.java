class Solution {
    public boolean isValid(String s) {
        final String opening = "({["; // opening delimiters
        final String closing = ")}]"; // respective closing delimiters
        Stack<Character> buffer = new Stack<>();
        for(char c:s.toCharArray()){ 
            if(opening.indexOf(c)!=-1)// this is a left delimiter
                buffer.push(c);
            else if(closing.indexOf(c)!=-1){ // this is a right delimiter
                if (buffer.isEmpty()) // nothing to match with
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false; // mismatched delimiter
            } 
        } 
        
        return buffer.isEmpty( ); // were all opening delimiters matched?
    }
}
