package Arrays;

import java.util.Arrays;

public class rotateImage {
    int[][] rotateImage(int[][] a) {
        int size = a.length - 1;
        for (int i = 0; i < a.length / 2; i++) {
            rotate(a, i, size);
            size -= 2;
        }
        return a;
    }

    void rotate(int[][] a, int i, int size) {
        int length = a.length - 1;
        for (int x = i; x < i + size; x++) {
            int temp = a[i][x];
            a[i][x] = a[length - x][i];
            a[length - x][i] = a[length - i][length - x];
            a[length - i][length - x] = a[x][length - i];
            a[x][length - i] = temp;
        }
    }

    public static void main(String[] args) {
        rotateImage rotateImage = new rotateImage();
        int[][] a = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{16, 17, 18, 19, 6},
                new int[]{15, 24, 25, 20, 7},
                new int[]{14, 23, 22, 21, 8},
                new int[]{13, 12, 11, 10, 9},
        };

        a = rotateImage.rotateImage(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

}
