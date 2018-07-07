package leetcode._350IntersectionOfTwoArraysII;

import java.util.*;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 1};
        int[] b = new int[]{2, 2};
        int[] c = intersect(a, b);
        for(int i:c) {
            System.out.print(i + " ");
        }
    }
}
