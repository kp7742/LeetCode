class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int top = -1;
        int[] mono = new int[nums2.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Generate monotonically decreasing stack
        for (int num : nums2) {
            while(top >= 0 && mono[top] < num){
                map.put(mono[top], num); //Mapping next greater element for given number
                --top;
            }
            mono[++top] = num;
        }
        
        //Finding next greater element's mapping
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
}