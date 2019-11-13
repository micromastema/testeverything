package com.zheng.testeverything.yiyi;

/**
 * @author zhengchentong on 2019/11/13
 */
public class test {


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea1(a);
        System.out.println(i);
    }

    private static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int a = (j - i) * (Math.min(height[i], height[j]));
                if (a > area) {
                    area = a;
                }
            }
        }
        return area;
    }

    private static int maxArea1(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[r], height[l]));
            if (height[l] < height[r]) {
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }

}
