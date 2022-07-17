class Solution {
    public int[] decode(int[] encoded) {
        //Permutation array would be of size + 1
        int n = encoded.length+1;
        int[] result = new int[n];
        
        //xor of all n elements in first element
        for(int i = 1; i <= n; i++)
            result[0] ^= i;
        
        //xor with odd positions of encoded
        for(int i = 1; i < n; i += 2)
            result[0] ^= encoded[i];
        
        //xor with each element with next element to find orignal value
        for(int i = 1; i < n; i++)
            result[i] = result[i-1] ^ encoded[i-1];
        
        return result;
    }
}