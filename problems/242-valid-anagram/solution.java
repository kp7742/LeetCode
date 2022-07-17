class Solution {
    public boolean isAnagram(String s, String t) {
        //Its not anagram if length is not the same
        if(s.length() != t.length())
            return false;
        
        //Get the character array
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        //Sort both the arrays by characters
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        //Compare both the arrays
        for(int i = 0; i < sArr.length; i++){
            //If characters doesn't match then its not anagram
            if(sArr[i] != tArr[i])
                return false;
        }
        
        return true;
    }
}