package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/1 21:46
 */
public class Q44_ {
    /**
     * 数字以 012345678910111213... 的格式序列化到一个字符串中。
     * 在这个序列中，第5位是5 第13位是1 ，请写一个函数求任意第 n 位对应的数字
     */
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        int digits = 1;

        while (true) {
            int numbers = countOfInteger(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }

            index -= digits * numbers;
            digits++;
        }

    }

    private int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 0; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits - 1);
    }

    private int countOfInteger(int digits) {
        if (digits == 1) {
            return 10;
        }

        int count = (int) Math.pow(10, digits - 1);
        return 9*count;
    }
}
