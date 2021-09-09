package Verkadal;/*
 * Created by Linfeng Li on 08/31/21
 * University of Illinois Chicago
 */

import java.util.Arrays;

public class blurFaces {
    double[][] blurFaces(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        double[][] ans = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = neighborAverage(img, i, j, n, m);
            }
        }
        return ans;
    }

    private double neighborAverage(int[][] img, int i, int j, int n, int m) {
//        boolean canUP = i - 1 >= 0;
//        boolean canDown = i + 1 < n;
//        boolean canLeft = j - 1 >= 0;
//        boolean canRight = j + 1 < m;
        double sum = 0;
        int count = 0;

        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                if (i + a >= 0 && i + a < n && j + b >= 0 && j + b < m) {
                    if (i + a == i && j + b == j) {
                    } else {
                        sum += img[i + a][j + b];
                        count++;
                    }
                }
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        blurFaces blurFaces = new blurFaces();
        System.out.println(Arrays.deepToString(blurFaces.blurFaces(new int[][]{
                new int[]{1, 4},
                new int[]{7, 10}
        })));
    }

}
