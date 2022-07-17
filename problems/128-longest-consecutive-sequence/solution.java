class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        //Populate Set - O(n)
        for(int num : nums)
            set.add(num);
        
        //Find longest sequence - O(n)
        int longestSeq = 0;
        for(int num: nums){
            //Check num is seq starter or not
            if(!set.contains(num - 1)){
                //Get seq length
                int len = 1, curr = num;
                while(set.contains(++curr))
                    ++len;

                longestSeq = Math.max(len, longestSeq);
            }
        }
        
        return longestSeq;
    }
}