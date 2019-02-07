package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/2/4 09:47
 */
public class Q60_Point {
    public static void main(String[] args) {
        System.out.println(getPoint(2));
    }

    /**
     * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为 s。输入n，返回 s 的所有可能的值出现的概率
     *
     * @return
     */
    public static List<Point> getPoint(int n) {
        final int maxPoint = 6;
        List<Point> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }

        int[][] helper = new int[2][];
        helper[0] = new int[maxPoint * n + 1];
        helper[1] = new int[maxPoint * n + 1];

//        for (int i = 0; i < maxPoint * n + 1; i++) {
//            helper[0][i] = 0;
//            helper[1][i] = 0;
//        }

        int flag = 0;
        for (int i = 1; i <= maxPoint; i++) {
            helper[flag][i] = 1;
        }

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                helper[1 - flag][i] = 0;
            }

            for (int i = k; i <= maxPoint * k; i++) {
                helper[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxPoint; j++) {
                    helper[1 - flag][i] += helper[flag][i - j];
                }
            }

            flag = 1 - flag;
        }

        double total = Math.pow(maxPoint, n);
        for (int i = 0; i < n; i++) {
            res.add(new Point(i, 0, 0, 0));
        }
        for (int i = n; i <= maxPoint * n; i++) {
            double ratio = (double) helper[flag][i] / total;
            res.add(new Point(i, helper[flag][i], (int) total, ratio));
//            System.out.println("i:" + i + " ratio:" + ratio);
        }
        return res;
    }

    static class Point{
        int point;
        int times;
        int total;
        double probability;

        public Point(int point, int times, int total, double probability) {
            this.point = point;
            this.times = times;
            this.total = total;
            this.probability = probability;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "point=" + point +
                    ", times=" + times +
                    ", total=" + total +
                    ", probability=" + probability +
                    '}';
        }
    }
}
