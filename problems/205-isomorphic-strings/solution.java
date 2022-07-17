class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smap = new int[128]; //Storing char to char by ascii number
        int[] tmap = new int[128]; //Storing reverse mapping for above map
        
        for(int i = 0; i < s.length(); i++){
            int chS = s.charAt(i), chT = t.charAt(i);
            
            //If mapping not found then create one
            if(smap[chS] == 0 && tmap[chT] == 0) {
                smap[chS] = chT;
                tmap[chT] = chS;
                continue;
            }
            
            //If one of the mapping doesn't match
            if(smap[chS] != chT || tmap[chT] != chS)
                return false;
        }
        
        return true;
    }
}