package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/1/24 19:10
 */
public class Q17_PrintFrom1ToMaxNbitNumber {
    public static void main(String[] args) {
        print(3);
    }

    /**
     * 输入数字 n，按顺序打印从 1 到最大的 n 位十进制数
     *
     * @param n
     */
    private static void print(int n) {
        if (n <= 0) {
            return;
        } else if (n <= 10) {
            for (int i = 1; i < Math.pow(10, n); i++) {
                System.out.println(i);
            }
        } else {
            char[] number = new char[n];
            for (int i = 0; i < 10; i++) {
                number[0] = (char) (i + '0');
                print(number, n, 0);
            }

        }
    }

    private static void print(char[] number, int n, int index) {
        if (index == n - 1) {
            printNum(number);
            return;
        }

        for (int j = 0; j < 10; j++) {
            number[index + 1] = (char) (j + '0');
            print(number, n, index + 1);
        }
    }

    private static void printNum(char[] number) {
        boolean isBegining0 = true;
        int len = number.length;

        for (int i = 0; i < len; i++) {
            if (isBegining0 && number[i] != '0') {
                isBegining0 = false;
            }

            if (!isBegining0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

}
