package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/22 23:49
 */
public class Q4_FindNumInDeArray {
    public static void main(String[] args){
        int[][] arr = {{1,2,8,9},
                       {2,4,9,12},
                       {4,7,10,13},
                       {6,8,11,15}};
        System.out.println(find(arr,10));
    }

    /**
     * 在二维数组中，行从左到右递增，列从上到下递增，查找某值是否在数组中。
     *
     * 解法：选取某个角，例如右上角 比较后，如果右上角值大于 num,往下找; 如果小于 num,往左找
     * @param arr
     * @param num
     * @return
     */
    private static boolean find(int[][] arr, int num) {
        if (arr == null) {
            return false;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        if (rows < 0 || cols < 0) {
            return false;
        }

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (arr[row][col] == num) {
                return true;
            } else if (arr[row][col] > num) {
                col--;
            } else {
                row++;
            }
            System.out.println("row:"+row + " col:"+col);
        }
        return false;
    }


}
