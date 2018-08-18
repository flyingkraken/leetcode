boolean sContainsT(int mapS[], int mapT[]) {// Runtime = O(256) = O(1)
    for (int i = 0; i < mapT.length; i++) {// s should cover all characters in t
        if (mapT[i] > mapS[i])
            return false; 
    }           
    return true;
}

public String minWindow(String s, String t) {   
    int mapS[] = new int[256];// Count characters in s
    int mapT[] = new int[256];// Count characters in t      
    for (char ch : t.toCharArray())
        mapT[ch]++;

    String res = "";
    int right = 0, min = Integer.MAX_VALUE;         
    for (int i = 0; i < s.length(); i++) {// Two pointers of the sliding window: i(left), right
        while (right < s.length() && !sContainsT(mapS, mapT)) {// Extend the right pointer of the sliding window
            mapS[s.charAt(right)]++;
            right++;
        }
        if (sContainsT(mapS, mapT) && min > right - i + 1) {
            res = s.substring(i, right);
            min = right - i + 1;
        }
        mapS[s.charAt(i)]--;// Shrink the left pointer from i to i + 1
    }
    return res;
}
