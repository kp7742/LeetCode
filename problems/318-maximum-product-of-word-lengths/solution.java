class Solution {
    public int maxProduct(String[] words) {
        int maxLen = 0, maskCount = 0;
        int[] masks = new int[words.length];
        
        for(int w = 0; w < words.length; w++){
            String word = words[w];
            
            //Calculate character mask for word;
            for(int c = 0; c < word.length(); c++)
                masks[w] |= 1 << (word.charAt(c) - 'a');
            
            //Check this mask aginst other stored ones
            for(int m = 0; m < maskCount; m++){
                if(m == w || (masks[m] & masks[w]) != 0)
                    continue;
                
                maxLen = Math.max(words[m].length() * word.length(), maxLen);
            }

            maskCount++;
        }
        
        return maxLen;
    }
}