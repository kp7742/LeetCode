class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int len = s.length();
        
        int l = 0; // Left pointer
        int r = len - 1; // Right pointer
        
        while(l != len/2){
            if(s.charAt(l) != s.charAt(r))
                return false;
            
            l++; // Move forward
            r--; // Move backward
        }
        
        return true;
    }
}