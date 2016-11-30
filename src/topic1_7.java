import java.util.Arrays;

/**
 * 编写一个算法,若M*N矩阵中某个元素为0,则将其所在的行与列清零
 */
public class topic1_7 {
    int[][] arr={{0,1,2,3},{1,2,3,4},{2,3,4,0},{3,4,0,1}};
    topic1_7(){
        print_array(arr);
        method1();
        print_array(arr);
    }

    public void method1(){
        boolean[] row=new boolean[arr.length];
        boolean[] column=new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==0){
                    row[i]=true;
                    column[j]=true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(row[i]||column[j]){
                    arr[i][j]=0;
                }
            }
        }
    }

    private void print_array(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
