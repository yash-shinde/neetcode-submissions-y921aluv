class Solution {
    private static int[] memo = new int[301];
    public boolean wordBreak(String s, List<String> wordDict) {
        Arrays.fill(memo,-1);
        HashSet<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict, 0);
    }

    private boolean dfs(String s, HashSet<String> wordSet, int i) {
        if (i == s.length()) {
            return true;
        }

        if(memo[i] != -1) return memo[i] == 1 ? true : false;

        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(s, wordSet, j + 1)) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[i] = 0;
        return false;
    }
}
