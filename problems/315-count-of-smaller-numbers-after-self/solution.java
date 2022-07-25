class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //Time Complexity: O(N log(N)), Space Complexity: O(N)
        List<Integer> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        
        //Copy Nums
        for(int num : nums){
            result.add(num); 
            numList.add(num);
        }
        
        //Sort array
        Collections.sort(numList);
        
        //Binary search each num
        for(int i = 0; i < result.size(); i++){
            int left = 0, right = numList.size() - 1, num = result.get(i);
            
            while(left <= right){
                int mid = (left + right) / 2;
                
                if(numList.get(mid) < num){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            //Delete element after search to skip recount
            numList.remove(left);
            
            //Replace num with left section length
            result.set(i, left);
        }
        
        return result;
    }
}