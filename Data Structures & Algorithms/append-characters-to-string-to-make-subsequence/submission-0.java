class Solution {
    public int appendCharacters(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return t.length();
        int s_len = s.length();
        int t_len = t.length();
        int l = 0;
        int r = 0;
        while(l<s.length() && r<t.length()){
            if(s.charAt(l) == t.charAt(r)){
                r++;
            }
            l++;
        }
        return t.length() - r; 
    }
}