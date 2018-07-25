class Solution {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            Map<Character, Integer> maps = new HashMap<>();
            Map<Character, Integer> mapt = new HashMap<>();
            for (int i=0; i<s.length(); i++) {
                if (maps.containsKey(s.charAt(i))) {
                    maps.put(s.charAt(i), maps.get(s.charAt(i)) + 1);
                } else {
                    maps.put(s.charAt(i), 1);
                }
                if (mapt.containsKey(t.charAt(i))) {
                    mapt.put(t.charAt(i), mapt.get(t.charAt(i)) + 1);
                } else {
                    mapt.put(t.charAt(i), 1);
                }
            }
            for (int i=0; i<s.length(); i++) {
                if (mapt.containsKey(s.charAt(i))) {
                    if (maps.get(s.charAt(i)).intValue() != mapt.get(s.charAt(i)).intValue()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}