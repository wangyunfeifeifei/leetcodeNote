import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (!map.containsKey(k)) {
                map.put(k, 0);
            }
            map.put(k, map.get(k) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;   
    }
    public static void main(String[] args) {
        
    }
}