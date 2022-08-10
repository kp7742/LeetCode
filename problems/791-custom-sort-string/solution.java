class Solution {
    public String customSortString(String order, String s) {
        //Count chars from string
        int[] count = new int[26];
        for (char c: s.toCharArray())
            count[c - 'a']++;
        
        StringBuilder ans = new StringBuilder();
        
        //Add chars from Order string
        //Inplace of original order chars
        for (char c: order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);
            
            count[c - 'a'] = 0;
        }
        
        //Add rest of the chars from string
        for (char c = 'a'; c <= 'z'; ++c)
            for (int i = 0; i < count[c - 'a']; ++i)
                ans.append(c);

        return ans.toString();
    }
}