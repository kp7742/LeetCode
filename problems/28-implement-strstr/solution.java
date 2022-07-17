class Solution {
    public int strStr(String haystack, String needle) {
        int nl = needle.length();
        if(nl == 0)
            return 0; //Base case as per the Clarification part
        
        int hl = haystack.length();
        if(hl < nl)
            return -1; //Shouldn't be possible
        
        //Window search
        for(int s = 0; s < (hl - nl) + 1; s++)
            if(haystack.substring(s, s + nl).startsWith(needle))
                return s;
        
        return -1;
    }
}