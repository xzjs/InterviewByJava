import java.util.Arrays;

/**
 * 给定一幅由M*N矩阵组成的图像,其中你每个像素的大小为4字节,编写一个方法,将图像旋转90°。不占用额外的空间能否做到
 * 答案是,做不到!!!真是坑
 */
public class topic1_6 {
    int m = 2, n = 3;
    int array[][] = {{1, 2, 3}, {4, 5, 6}};

    topic1_6() {
        print_array(array);
        rotate();
    }

    public void rotate() {
        int[][] result=new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m-i-1]=array[i][j];
            }
        }
        print_array(result);
    }

    private void print_array(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

    }
}
