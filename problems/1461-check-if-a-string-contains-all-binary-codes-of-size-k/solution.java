class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k; //2^k
        int mask = total - 1; //2^k - 1
        boolean[] map = new boolean[total];
        
        //Bits Window Checking
        for(int i = 0; i + k <= s.length(); i++){
            int bits = Integer.parseInt(s.substring(i, i + k), 2) & mask;
            
            //Skip exiting one
            if (map[bits])
                continue;
            
            //Add bits into set
            map[bits] = true;
            
            //Got all possible unique combinations
            if (--total == 0)
                return true;
        }
        
        return false;
    }
}