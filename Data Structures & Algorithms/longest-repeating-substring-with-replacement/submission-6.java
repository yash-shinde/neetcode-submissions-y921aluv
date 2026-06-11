class Solution {
    public int characterReplacement(String s, int k) {
        //formula : for any window we will choose the max occurring char
        //and try to replace other char with it upto k times
        //the optimal ans will include a window with the maxocc element
        //so the ans will be max occur element + k 
        Map<Character,Integer> count = new HashMap<>();
        int l=0;
        int res = 0;
        int maxF =0;
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(count.get(s.charAt(r)),maxF);

            //if window has more than k char 
            //all cant be made into the same element
            while ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
