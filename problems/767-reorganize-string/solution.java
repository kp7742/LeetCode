class Solution {
    public String reorganizeString(String s) {
        //Find word freq
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        //Find max freq char
        int max = 0, ch = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                ch = i;
            }
        }
        
        //If mac freq char appear more then half of string
        if (max > (s.length() + 1) / 2) {
            return ""; 
        }
        
        int idx = 0;
        char[] res = new char[s.length()];
        
        //Fill up max char in even position
        while (freq[ch] > 0) {
            res[idx] = (char) (ch + 'a');
            idx += 2;
            freq[ch]--;
        }
        
        //Fill rest of the char in even positions
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}