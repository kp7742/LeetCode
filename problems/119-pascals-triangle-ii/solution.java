class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        
        //Row: 1
        result.add(1);
        if(rowIndex == 0)
            return result;
        
        //Row: 2
        result.add(1);
        if(rowIndex == 1)
            return result;
        
        //Row: 2+
        for(int r = 2; r <= rowIndex; r++){
            List<Integer> next = new ArrayList<>();
            
            next.add(result.get(0)); //First Entry
            
            //Middle calculations
            for(int n = 0; n < result.size() - 1; n++){
                next.add(result.get(n) + result.get(n + 1));
            }
            
            next.add(result.get(0)); //Last Entry
            
            result = next;
        }
        
        return result;
    }
}