class Solution {
    public boolean isValid(String s) {
        int top = -1;
        char[] stack = new char[s.length()];
        
        for(int i=0; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if(curr == '(' || curr == '{' || curr == '['){
                stack[++top] = curr; //Push element
            } else {
                if(top < 0)
                    return false;
                
                char topC = stack[top];
                
                boolean cond1 = topC == '(' && curr == ')';
                boolean cond2 = topC == '{' && curr == '}';
                boolean cond3 = topC == '[' && curr == ']';
                
                if(cond1 || cond2 || cond3)
                    --top; // Pop element
                else
                    return false;
            }
        }
        
        return top < 0;
    }
}