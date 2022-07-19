class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        //Row: 1
        result.add(List.of(1));
        if(numRows == 1)
            return result;
        
        //Row: 2
        result.add(List.of(1, 1));
        if(numRows == 2)
            return result;
        
        //Row: 2+
        for(int r = 2; r < numRows; r++){
            List<Integer> prev = result.get(r - 1);
            List<Integer> next = new ArrayList<>();
            
            next.add(prev.get(0)); //First Entry
            
            //Middle calculations
            for(int n = 0; n < prev.size() - 1; n++){
                next.add(prev.get(n) + prev.get(n + 1));
            }
            
            next.add(prev.get(prev.size() - 1)); //Last Entry
            
            result.add(next);
        }
        
        return result;
    }
}