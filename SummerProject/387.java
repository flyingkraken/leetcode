public int firstUniqChar(String s) {
    int n = s.length();
    int[] alp = new int[26];
    int[] loc = new int[26];
    
    for (int i = 0; i < n; ++i) {
        alp[s.charAt(i) - 'a']++;
        loc[s.charAt(i) - 'a'] = i;
    }
    
    int ret = -1;
    for (int i = 0; i < 26; ++i) {
        if (alp[i] == 1) {
            ret = ret == -1 ? loc[i] : Math.min(ret, loc[i]);
        }
    }
    
    return ret;
}
