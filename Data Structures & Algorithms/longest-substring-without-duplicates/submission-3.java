class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash =new HashSet<Character>();
        int l = 0;
        int res = 0;

        for(int r=0;r<s.length();r++){
            while(hash.contains(s.charAt(r))){
                hash.remove(s.charAt(l));
                l++;
            }
            hash.add(s.charAt(r));
            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
