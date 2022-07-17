class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; //Take first string as prefix
        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){ //Try to match starting chars in current string
                prefix = prefix.substring(0, prefix.length() - 1); //Reduce prefix by 1 char
            }
        }
        return prefix;
    }
}