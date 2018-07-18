class Solution {
    public static int[] plusOne(int[] digits) {
        int c = 1;
        for(int i=digits.length - 1; i >= 0; i--) {
            if (c == 0) {
                return digits;
            }
            int tmp = digits[i] + 1;
            c = tmp / 10;
            digits[i] = tmp % 10;
        }
        if (c != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i=1;i<digits.length;i++) {
                ans[i] = 0;
            }
            return ans;
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        plusOne(arr);
        for(int i: arr) {
            System.out.println(i);
        }
    }
}