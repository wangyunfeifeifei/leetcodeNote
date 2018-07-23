class Solution {
    public static int reverse(int x) {
        char[] charArr = String.valueOf(x).toCharArray();
        int i, j;
        if(x > 0) {
            i = 0;
            j = charArr.length - 1;
            while(i < j) {
                char t  = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = t;
                i++;
                j--;
            }
        } else {
            i = 1;
            j = charArr.length - 1;
            while(i < j) {
                char t  = charArr[i];
                charArr[i] = charArr[j];
                charArr[j] = t;
                i++;
                j--;
            }
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        String ansString = x > 0 ? String.valueOf(charArr) : String.valueOf(charArr).substring(1);
        if(max.length() <= ansString.length() && ansString.compareTo(max) > 0) {
            return 0;
        } else {
            int ans = Integer.valueOf(String.valueOf(charArr));
            return ans;
        }
    }
    public static void main(String[] args) {
        int a = 1534236469;
        int ans = reverse(a);
        System.out.println(ans);
        int b = 123;
        ans = reverse(b);
        System.out.println(ans);
    }
}