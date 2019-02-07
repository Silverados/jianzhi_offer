package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/1/29 23:06
 */
public class Q29_spiralOrder {
    /**
     * LeetCode 54
     *
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return res;
        }

        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    public void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res.add(m[tR][i]);
                // System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res.add(m[i][tC]);
                // System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                res.add(m[tR][curC]);
                // System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                res.add(m[curR][dC]);
                // System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                res.add(m[dR][curC]);
                // System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                res.add(m[curR][tC]);
                // System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }
}
