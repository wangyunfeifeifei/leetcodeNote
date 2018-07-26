class Solution {
    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j;) {
            if (!isValid(s.charAt(i))) {
                i ++;
            } else if (!isValid(s.charAt(j))) {
                j --;
            } else if (!isEqual(s.charAt(i), s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    private static boolean isEqual(char a, char b) {
        return a <= '9' && a >= '0' ? a == b : a == b || a - ('a' - 'A') == b || a + ('a' - 'A') == b;
    }
    private static boolean isValid(char a) {
        return a <= '9' && a >= '0' || a <= 'z' && a >= 'a' || a <= 'Z' && a >= 'A';
    }
    public static void main(String[] args) {
        String s = "0P";
        boolean b = isPalindrome(s);
        System.out.println(isEqual('0', 'P'));
        System.out.println(b);
    }
}