class Solution {
    public String minWindow(String s, String t) {
        //use 2 maps to track the counts of chars
        //use 2 vars - need , have that track how many character have 
        //the same count as in the target 
        Map<Character,Integer> sCount = new HashMap<Character,Integer>();
        Map<Character,Integer> tCount = new HashMap<Character,Integer>();

        for(int i=0;i<t.length();i++){
            tCount.put(t.charAt(i),tCount.getOrDefault(t.charAt(i),0)+1);
        }
        int have = 0;
        int need = tCount.size();
        int[] res = {-1,-1};
        int minLen = Integer.MAX_VALUE;
        int l=0;
        for(int r =0;r<s.length();r++){
            char c = s.charAt(r);
            sCount.put(c,sCount.getOrDefault(c,0)+1);

            if(tCount.containsKey(c) && sCount.get(c).equals(tCount.get(c))){
                have++;
            }

            while(have == need){
                if((r-l+1) <minLen){
                    minLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                sCount.put(leftChar,sCount.get(leftChar)-1);
                if (tCount.containsKey(leftChar) && sCount.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
