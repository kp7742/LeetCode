class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int l = 0, r = 0; r < n; r++){
            char ch = s.charAt(r);
            
            //We got previous entry so move left pointer
            if(map.containsKey(ch)){
                l = Math.max(l, map.get(ch));
            }
            
            //Update length and map entry
            maxLen = Math.max(maxLen, r - l + 1);
            map.put(ch, r + 1);
        }
        
//         //O(n2)
//         for(int l = 0, r = 0; l < n && r < n; l++){
//             //Reset and move forward
//             set.clear();
            
//             for(r = l; r < n; r++){
//                 char ch = s.charAt(r);
                
//                 //Check prev entry
//                 if(set.contains(ch)){
//                     break;
//                 }
                
//                 System.out.println(ch);
            
//                 //Put char entry
//                 set.add(ch);
//             }
            
//             System.out.println();
            
//             maxLen = Math.max(maxLen, r - l); //Calculate maximum length
//         }
        
        return maxLen;
    }
}