class Solution {
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int i = 0, j = charArr.length - 1;
        while(i<j) {
            char t = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = t;
            i++;
            j--;
        }
        return String.valueOf(charArr);
    }
}