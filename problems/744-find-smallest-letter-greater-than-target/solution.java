class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
//         //Linear Search
//         boolean[] seen = new boolean[26];
//         for (char c: letters)
//             seen[c - 'a'] = true;
        
//         while (true) {
//             //Because we need char greater than target
//             target++;
            
//             //Wrap up around a-z
//             if (target > 'z') 
//                 target = 'a';
            
//             //Found in letters
//             if (seen[target - 'a']) 
//                 return target;
//         }
        //Linear Scan
        // for (char c: letters)
        //     if (c > target) 
        //         return c;
        // return letters[0];
        //Binary Search
        int l = 0, r = letters.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            
            if(letters[mid] <= target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l % letters.length];
    }
}