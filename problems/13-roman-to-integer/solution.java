import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Roman numeral symbol to integer conversion map
        HashMap<Character, Integer> conv = new HashMap<>();
        conv.put('I', 1);
        conv.put('V', 5);
        conv.put('X', 10);
        conv.put('L', 50);
        conv.put('C', 100);
        conv.put('D', 500);
        conv.put('M', 1000);
        
        int res = 0;
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            int curr = conv.get(s.charAt(i));
            
            if(i != (len - 1)){
                int next = conv.get(s.charAt(i+1));
                if(curr < next){
                    curr = (next - curr);
                    i++; // Skip next numeral
                }
            }

            res += curr;
        }
        
        return res;
    }
}